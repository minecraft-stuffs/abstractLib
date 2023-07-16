package com.rhseung.abstractlib.data

import com.rhseung.abstractlib.registration.key.BasicItemGroup
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.block.Block
import net.minecraft.enchantment.Enchantment
import net.minecraft.entity.EntityType
import net.minecraft.entity.attribute.EntityAttribute
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.registry.RegistryKey
import net.minecraft.stat.StatType
import net.minecraft.util.Identifier

class LanguageHandler(
    val modId: String,
    private val translationBuilder: FabricLanguageProvider.TranslationBuilder
) {
    data class Lang<T: Any>(val subject: T, val name: String)
    
    fun <T: Item> adds(items: Collection<T>, iteratee: (T) -> String) {
        items.forEach {
            translationBuilder.add(it, iteratee(it))
        }
    }
    
    fun <T: Block> adds(blocks: Collection<T>, iteratee: (T) -> String) {
        blocks.forEach {
            translationBuilder.add(it, iteratee(it))
        }
    }
    
    fun <T: Identifier> adds(ids: Collection<T>, iteratee: (T) -> String) {
        ids.forEach {
            translationBuilder.add(it, iteratee(it))
        }
    }
    
    fun adds(names: Collection<String>, iteratee: (String) -> String) {
        names.forEach {
            translationBuilder.add(Identifier(modId, it), iteratee(it))
        }
    }
    
    fun <T: Enchantment> adds(enchantments: Collection<T>, iteratee: (T) -> String) {
        enchantments.forEach {
            translationBuilder.add(it, iteratee(it))
        }
    }
    
    fun <T: EntityType<*>> adds(entityTypes: Collection<T>, iteratee: (T) -> String) {
        entityTypes.forEach {
            translationBuilder.add(it, iteratee(it))
        }
    }

    fun <T: EntityAttribute> adds(entityAttributes: Collection<T>, iteratee: (T) -> String) {
        entityAttributes.forEach {
            translationBuilder.add(it, iteratee(it))
        }
    }
    
    fun <T: BasicItemGroup> adds(itemGroups: Collection<T>, iteratee: (T) -> String) {
        itemGroups.forEach {
            translationBuilder.add(it.registry, iteratee(it))
        }
    }
    
    fun <T: RegistryKey<ItemGroup>> adds(itemGroups: Collection<T>, iteratee: (T) -> String) {
        itemGroups.forEach {
            translationBuilder.add(it, iteratee(it))
        }
    }
    
    fun <T: StatusEffect> adds(statusEffects: Collection<T>, iteratee: (T) -> String) {
        statusEffects.forEach {
            translationBuilder.add(it, iteratee(it))
        }
    }
    
    fun <T: StatType<*>> adds(statTypes: Collection<T>, iteratee: (T) -> String) {
        statTypes.forEach {
            translationBuilder.add(it, iteratee(it))
        }
    }
    
    operator fun plusAssign(lang: Lang<Item>) {
        translationBuilder.add(lang.subject, lang.name)
    }
    
    operator fun plusAssign(lang: Lang<Block>) {
        translationBuilder.add(lang.subject, lang.name)
    }
    
    operator fun plusAssign(lang: Lang<Identifier>) {
        translationBuilder.add(lang.subject, lang.name)
    }
    
    operator fun plusAssign(lang: Lang<String>) {
        translationBuilder.add(Identifier(modId, lang.subject), lang.name)
    }
    
    operator fun plusAssign(lang: Lang<Enchantment>) {
        translationBuilder.add(lang.subject, lang.name)
    }
    
    operator fun plusAssign(lang: Lang<EntityType<*>>) {
        translationBuilder.add(lang.subject, lang.name)
    }
    
    operator fun plusAssign(lang: Lang<EntityAttribute>) {
        translationBuilder.add(lang.subject, lang.name)
    }
    
    operator fun plusAssign(lang: Lang<BasicItemGroup>) {
        translationBuilder.add(lang.subject.registry, lang.name)
    }
    
    operator fun plusAssign(lang: Lang<StatusEffect>) {
        translationBuilder.add(lang.subject, lang.name)
    }
    
    operator fun plusAssign(lang: Lang<StatType<*>>) {
        translationBuilder.add(lang.subject, lang.name)
    }
    
    companion object {
        infix fun Item.aka(name: String) = Lang(this, name)
        infix fun Block.aka(name: String) = Lang(this, name)
        infix fun Identifier.aka(name: String) = Lang(this, name)
        infix fun String.aka(name: String) = Lang(this, name)
        infix fun Enchantment.aka(name: String) = Lang(this, name)
        infix fun EntityType<*>.aka(name: String) = Lang(this, name)
        infix fun EntityAttribute.aka(name: String) = Lang(this, name)
        infix fun BasicItemGroup.aka(name: String) = Lang(this, name)
        infix fun StatusEffect.aka(name: String) = Lang(this, name)
        infix fun StatType<*>.aka(name: String) = Lang(this, name)
    }
}