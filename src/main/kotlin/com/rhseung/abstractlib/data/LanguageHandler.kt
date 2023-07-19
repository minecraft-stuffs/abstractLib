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
    
    @JvmName("plusAssignItem")
    operator fun plusAssign(lang: Lang<Item>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignListItem")
    operator fun plusAssign(lang: List<Lang<Item>>) {
        lang.forEach(::plusAssign)
    }

    @JvmName("plusAssignBlock")
    operator fun plusAssign(lang: Lang<Block>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignListBlock")
    operator fun plusAssign(lang: List<Lang<Block>>) {
        lang.forEach(::plusAssign)
    }

    @JvmName("plusAssignIdentifier")
    operator fun plusAssign(lang: Lang<Identifier>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignListIdentifier")
    operator fun plusAssign(lang: List<Lang<Identifier>>) {
        lang.forEach(::plusAssign)
    }

    @JvmName("plusAssignString")
    operator fun plusAssign(lang: Lang<String>) {
        translationBuilder.add(Identifier(modId, lang.subject), lang.name)
    }

    @JvmName("plusAssignListString")
    operator fun plusAssign(lang: List<Lang<String>>) {
        lang.forEach(::plusAssign)
    }

    @JvmName("plusAssignEnchantment")
    operator fun plusAssign(lang: Lang<Enchantment>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignListEnchantment")
    operator fun plusAssign(lang: List<Lang<Enchantment>>) {
        lang.forEach(::plusAssign)
    }

    @JvmName("plusAssignEntityType")
    operator fun plusAssign(lang: Lang<EntityType<*>>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignListEntityType")
    operator fun plusAssign(lang: List<Lang<EntityType<*>>>) {
        lang.forEach(::plusAssign)
    }

    @JvmName("plusAssignEntityAttribute")
    operator fun plusAssign(lang: Lang<EntityAttribute>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignListEntityAttribute")
    operator fun plusAssign(lang: List<Lang<EntityAttribute>>) {
        lang.forEach(::plusAssign)
    }

    @JvmName("plusAssignBasicItemGroup")
    operator fun plusAssign(lang: Lang<BasicItemGroup>) {
        translationBuilder.add(lang.subject.registry, lang.name)
    }

    @JvmName("plusAssignListBasicItemGroup")
    operator fun plusAssign(lang: List<Lang<BasicItemGroup>>) {
        lang.forEach(::plusAssign)
    }

    @JvmName("plusAssignItemGroup")
    operator fun plusAssign(lang: Lang<RegistryKey<ItemGroup>>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignListItemGroup")
    operator fun plusAssign(lang: List<Lang<RegistryKey<ItemGroup>>>) {
        lang.forEach(::plusAssign)
    }

    @JvmName("plusAssignStatusEffect")
    operator fun plusAssign(lang: Lang<StatusEffect>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignListStatusEffect")
    operator fun plusAssign(lang: List<Lang<StatusEffect>>) {
        lang.forEach(::plusAssign)
    }

    @JvmName("plusAssignStatType")
    operator fun plusAssign(lang: Lang<StatType<*>>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignListStatType")
    operator fun plusAssign(lang: List<Lang<StatType<*>>>) {
        lang.forEach(::plusAssign)
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
        infix fun RegistryKey<ItemGroup>.aka(name: String) = Lang(this, name)
        infix fun StatusEffect.aka(name: String) = Lang(this, name)
        infix fun StatType<*>.aka(name: String) = Lang(this, name)

        @JvmName("ItemAka")
        infix fun <T: Item> Collection<T>.aka(iteratee: (T) -> String) = map { it aka iteratee(it) }
        @JvmName("BlockAka")
        infix fun <T: Block> Collection<T>.aka(iteratee: (T) -> String) = map { it aka iteratee(it) }
        @JvmName("IdentifierAka")
        infix fun <T: Identifier> Collection<T>.aka(iteratee: (T) -> String) = map { it aka iteratee(it) }
        @JvmName("StringAka")
        infix fun Collection<String>.aka(iteratee: (String) -> String) = map { it aka iteratee(it) }
        @JvmName("EnchantmentAka")
        infix fun <T: Enchantment> Collection<T>.aka(iteratee: (T) -> String) = map { it aka iteratee(it) }
        @JvmName("EntityTypeAka")
        infix fun <T: EntityType<*>> Collection<T>.aka(iteratee: (T) -> String) = map { it aka iteratee(it) }
        @JvmName("EntityAttributeAka")
        infix fun <T: EntityAttribute> Collection<T>.aka(iteratee: (T) -> String) = map { it aka iteratee(it) }
        @JvmName("BasicItemGroupAka")
        infix fun <T: BasicItemGroup> Collection<T>.aka(iteratee: (T) -> String) = map { it aka iteratee(it) }
        @JvmName("ItemGroupAka")
        infix fun <T: RegistryKey<ItemGroup>> Collection<T>.aka(iteratee: (T) -> String) = map { it aka iteratee(it) }
        @JvmName("StatusEffectAka")
        infix fun <T: StatusEffect> Collection<T>.aka(iteratee: (T) -> String) = map { it aka iteratee(it) }
        @JvmName("StatTypeAka")
        infix fun <T: StatType<*>> Collection<T>.aka(iteratee: (T) -> String) = map { it aka iteratee(it) }
    }
}