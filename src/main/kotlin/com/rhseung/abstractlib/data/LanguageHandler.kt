package com.rhseung.abstractlib.data

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
    val translationBuilder: FabricLanguageProvider.TranslationBuilder
) {
    operator fun plusAssign(new: Pair<Item, String>) {
        translationBuilder.add(new.first, new.second)
    }

    operator fun plusAssign(new: Pair<Block, String>) {
        translationBuilder.add(new.first, new.second)
    }

    operator fun plusAssign(new: Pair<Identifier, String>) {
        translationBuilder.add(new.first, new.second)
    }

    operator fun plusAssign(new: Pair<String, String>) {
        translationBuilder.add(Identifier(modId, new.first), new.second)
    }

    operator fun plusAssign(new: Pair<Enchantment, String>) {
        translationBuilder.add(new.first, new.second)
    }

    operator fun plusAssign(new: Pair<EntityType<*>, String>) {
        translationBuilder.add(new.first, new.second)
    }

    operator fun plusAssign(new: Pair<EntityAttribute, String>) {
        translationBuilder.add(new.first, new.second)
    }

    operator fun plusAssign(new: Pair<RegistryKey<ItemGroup>, String>) {
        translationBuilder.add(new.first, new.second)
    }

    operator fun plusAssign(new: Pair<StatusEffect, String>) {
        translationBuilder.add(new.first, new.second)
    }

    operator fun plusAssign(new: Pair<StatType<*>, String>) {
        translationBuilder.add(new.first, new.second)
    }
}