package com.rhseung.abstractlib.data

import com.rhseung.abstractlib.registration.key.Group
import com.rhseung.abstractlib.registration.key.ItemGroup
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.block.Block
import net.minecraft.enchantment.Enchantment
import net.minecraft.entity.EntityType
import net.minecraft.entity.attribute.EntityAttribute
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.item.Item
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

    @JvmName("plusAssignBlock")
    operator fun plusAssign(lang: Lang<Block>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignIdentifier")
    operator fun plusAssign(lang: Lang<Identifier>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignString")
    operator fun plusAssign(lang: Lang<String>) {
        translationBuilder.add(Identifier(modId, lang.subject), lang.name)
    }

    @JvmName("plusAssignEnchantment")
    operator fun plusAssign(lang: Lang<Enchantment>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignEntityType")
    operator fun plusAssign(lang: Lang<EntityType<*>>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignEntityAttribute")
    operator fun plusAssign(lang: Lang<EntityAttribute>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignItemGroup")
    operator fun plusAssign(lang: Lang<ItemGroup>) {
        translationBuilder.add(lang.subject.registrykey, lang.name)
    }

    @JvmName("plusAssignGroup")
    operator fun plusAssign(lang: Lang<Group>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignStatusEffect")
    operator fun plusAssign(lang: Lang<StatusEffect>) {
        translationBuilder.add(lang.subject, lang.name)
    }

    @JvmName("plusAssignStatType")
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
        infix fun ItemGroup.aka(name: String) = Lang(this, name)
        infix fun Group.aka(name: String) = Lang(this, name)
        infix fun StatusEffect.aka(name: String) = Lang(this, name)
        infix fun StatType<*>.aka(name: String) = Lang(this, name)
    }
}