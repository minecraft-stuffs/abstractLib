package com.rhseung.abstractlib.data

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.util.Identifier
import java.util.function.BiConsumer
import java.util.function.Supplier

class ItemModelHandler(
    val modId: String,
    val generator: ItemModelGenerator
) {
    fun builder(lambda: Builder.() -> Unit): Builder {
        return Builder(modId).apply(lambda)
    }

    class Builder(val modId: String) {
        lateinit var model: Model
        var overrides = mutableListOf<Override>()

        fun model(lambda: ModelBuilder.() -> Unit): Builder {
            val model = ModelBuilder(modId).apply(lambda).build()
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

    data class Model(val id: Identifier, var parent: Identifier, val textures: MutableList<Texture>)

    class ModelBuilder(val modId: String) {
        private lateinit var id: Identifier
        private var parent = Parents.EMPTY
        private val textures = mutableListOf<Texture>()

        fun path(lambda: () -> String): ModelBuilder {
            id = Identifier(modId, lambda())
            return this
        }

        fun parent(lambda: () -> Identifier): ModelBuilder {
            parent = lambda()
            return this
        }

        fun textures(lambda: TextureListBuilder.() -> Unit): ModelBuilder {
            textures.addAll(TextureListBuilder().apply(lambda).build())
            return this
        }

        fun build() = Model(id, parent, textures)
    }

    data class Texture(var key: String, val path: String)

    class TextureBuilder {
        var key: String = ""
        var path: String = ""

        fun key(lambda: () -> String): TextureBuilder {
            this.key = lambda()
            return this
        }

        fun path(lambda: () -> String): TextureBuilder {
            this.path = lambda()
            return this
        }

        fun build() = Texture(key, path)
    }
    class TextureListBuilder {
        private val textureList = mutableListOf<Texture>()

        fun texture(lambda: TextureBuilder.() -> Unit): TextureListBuilder {
            val texture = TextureBuilder().apply(lambda).build()
            if (texture.key.isBlank())
                texture.key = "layer${textureList.count()}"

            textureList.add(texture)
            return this
        }

        fun <T : Any> from(collection: Collection<T>, lambda: TextureBuilder.(it: T) -> Unit): TextureListBuilder {
            collection.forEach {
                val texture = TextureBuilder().apply { lambda(it) }.build()
                if (texture.key.isBlank())
                    texture.key = "layer${textureList.count()}"

                textureList.add(texture)
            }
            return this
        }

        fun build() = textureList
    }

    data class Override(val predicates: MutableMap<Identifier, Number>, val model: Model)
    class OverrideBuilder(val modId: String) {
        var predicates = mutableMapOf<Identifier, Number>()
        lateinit var model: Model

        fun predicate(lambda: () -> Pair<String, Number>): OverrideBuilder {
            this.predicates[Identifier(modId, lambda().first)] = lambda().second
            return this
        }

        fun model(lambda: ModelBuilder.() -> Unit): OverrideBuilder {
            this.model = ModelBuilder(modId).apply(lambda).build()
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

            jsonObject.addProperty("parent", builder.model.parent.toString())

            if (builder.model.textures.isNotEmpty()) {
                val textureJsonObject = JsonObject()
                builder.model.textures.forEach { (textureKey: String, textureValue: String) ->
                    textureJsonObject.addProperty(textureKey, textureValue)
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
                    model {
                        path { override.model.id.path }
                        parent { override.model.parent }
                        textures {
                            from (override.model.textures) { texture ->
                                key { texture.key }
                                path { texture.path }
                            }
                        }
                    }
                }
            )
        }
    }
}