package com.rhseung.abstractlib.data

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.rhseung.abstractlib.render.model.Parents
import com.rhseung.abstractlib.render.model.TextureType
import com.rhseung.abstractlib.api.file.path.Location
import com.rhseung.abstractlib.api.file.path.URI
import com.rhseung.abstractlib.registration.key.Item
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.util.Identifier
import java.util.function.BiConsumer
import java.util.function.Supplier

class ItemModelHandler(
    val modId: String,
    private val generator: ItemModelGenerator
) {
    operator fun plusAssign(builder: Builder) {
        generate(builder)
    }
    
    companion object {
        fun builder(lambda: Builder.() -> Unit): Builder {
            return Builder().apply(lambda)
        }

        fun simple(item: Item, path: String = item.id.path): Builder {
            return builder {
                model(item.id.path) {
                    parent { Parents.GENERATED }
                    textures {
                        + path
                    }
                }
            }
        }
    }

    data class Model(val id: Identifier, var parent: URI, val textures: MutableList<Texture>)

    data class Texture(var type: String, val id: Identifier)

    data class Override(val predicates: MutableMap<Identifier, Number>, val model: Model)

    class Builder {
        val modId = URI.getModId()
        lateinit var model: Model
        var overrides = mutableListOf<Override>()

        fun model(path: String, lambda: ModelBuilder.() -> Unit): Builder {
            val model = ModelBuilder(Identifier(modId, "item/$path"), modId).apply(lambda).build()
            if (model.parent == Parents.EMPTY)
                model.parent = Parents.GENERATED

            this.model = model
            return this
        }

        fun overrides(lambda: OverrideListBuilder.() -> Unit): Builder {
            val overrides = OverrideListBuilder(modId).apply(lambda).build()
            overrides.forEach {
                if (it.model.parent == Parents.EMPTY)
                    it.model.parent = model.parent
            }

            this.overrides = overrides
            return this
        }
    }

    class ModelBuilder(val id: Identifier, val modId: String) {
        private var parent = Parents.EMPTY
        private val textures = mutableListOf<Texture>()

        fun parent(lambda: () -> URI): ModelBuilder {
            parent = lambda()
            return this
        }

        fun textures(lambda: TextureListBuilder.() -> Unit): ModelBuilder {
            textures.addAll(TextureListBuilder(modId).apply(lambda).build())
            return this
        }

        fun build() = Model(id, parent, textures)
    }

    class TextureListBuilder(val modId: String) {
        private val textureList = mutableListOf<Texture>()

        operator fun String.unaryPlus() {
            textureList.add(
                Texture(TextureType.LAYER(textureList.count()), Identifier(modId, "item/$this"))
            )
        }

        operator fun Pair<String, String>.unaryPlus() {
            textureList.add(Texture(first, Identifier(modId, "item/$second")))
        }

        operator fun Texture.unaryPlus() {
            textureList.add(this)
        }

        fun texture(lambda: () -> Pair<String, String>): TextureListBuilder {
            val texture = Texture(lambda().first, Identifier(modId, "item/" + lambda().second))
            if (texture.type.isBlank())
                texture.type = TextureType.LAYER(textureList.count())

            textureList.add(texture)
            return this
        }

        /**
         * ```
         * from (override.model.textures) { texture -> texture.type to texture.id }
         * from (override.model.textures) { (type, id) -> type to id }
         * from (override.model.textures) { it.type to it.id } ```
         */
        fun from(collection: Collection<Texture>, lambda: (Texture) -> Texture): TextureListBuilder {
            collection.forEach {
                textureList.add(lambda(it))
            }
            return this
        }

        fun build() = textureList
    }

    class OverrideBuilder(val modId: String) {
        var predicates = mutableMapOf<Identifier, Number>()
        lateinit var model: Model
        
        /**
         * 주의: `predicate`는 여러 번 사용할 수 있다.
         */
        fun predicate(lambda: () -> Pair<String, Number>): OverrideBuilder {
            this.predicates[Identifier(modId, lambda().first)] = lambda().second
            return this
        }

        fun model(path: String, lambda: ModelBuilder.() -> Unit): OverrideBuilder {
            this.model = ModelBuilder(Identifier(modId, "item/$path"), modId).apply(lambda).build()
            return this
        }

        fun build() = Override(predicates, model)
    }

    class OverrideListBuilder(val modId: String) {
        private val overrideList = mutableListOf<Override>()

        fun override(lambda: OverrideBuilder.() -> Unit): OverrideListBuilder {
            overrideList.add(OverrideBuilder(modId).apply(lambda).build())
            return this
        }

        fun build() = overrideList
    }

    private fun BiConsumer<Identifier, Supplier<JsonElement>>.accept(builder: Builder): Identifier {
        this.accept(builder.model.id, Supplier {
            val jsonObject = JsonObject()

            jsonObject.addProperty("parent", Location(builder.model.parent.toString()).toString())

            if (builder.model.textures.isNotEmpty()) {
                val textureJsonObject = JsonObject()
                builder.model.textures.forEach { (textureKey, textureValue) ->
                    textureJsonObject.addProperty(textureKey, textureValue.toString())
                }
                jsonObject.add("textures", textureJsonObject)
            }

            if (builder.overrides.isNotEmpty()) {
                val overrideJsonArray = JsonArray()
                builder.overrides.forEach { override ->
                    val eachOverride = JsonObject()

                    val eachPredicate = JsonObject()
                    override.predicates.forEach {
                        eachPredicate.addProperty(it.key.toString(), it.value)
                    }

                    eachOverride.add("predicate", eachPredicate)
                    eachOverride.addProperty("model", override.model.toString())

                    overrideJsonArray.add(eachOverride)
                }
                jsonObject.add("overrides", overrideJsonArray)
            }

            jsonObject
        })

        return builder.model.id
    }

    fun generate(builder: Builder) {
        val modelCollector = generator.writer

        modelCollector.accept(builder)

        builder.overrides.forEach { override ->
            modelCollector.accept(
                builder {
                    model (override.model.id.path) {
                        parent { override.model.parent }
                        textures {
                            from (override.model.textures) { it }
                        }
                    }
                }
            )
        }
    }
}