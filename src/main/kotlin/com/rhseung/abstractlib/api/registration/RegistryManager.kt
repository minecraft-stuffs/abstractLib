package com.rhseung.abstractlib.api.registration

import com.rhseung.abstractlib.api.file.Location
import com.rhseung.abstractlib.api.file.Location.Companion.with
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.Block
import net.minecraft.item.*
import net.minecraft.recipe.RecipeSerializer
import net.minecraft.recipe.RecipeType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import kotlin.reflect.KClass

object RegistryManager {
    // Items
    fun <T : Item> register(
        item: T,
        id: Location,
        group: ItemGroup? = null,
    ): T {
        if (group != null)
            ItemGroupEvents.modifyEntriesEvent(group)
                .register(ItemGroupEvents.ModifyEntries { entries -> entries.add(item) })
        return Registry.register(Registries.ITEM, id, item)
    }

    fun <T : Item> getItems(
        clazz: KClass<out T>
    ): List<T> {
        return Registries.ITEM.streamEntries().map { it.value() }.filter { clazz.isInstance(it) }.map { it as T }.toList()
    }

    fun getId(item: Item): Location {
        return Location(Registries.ITEM.getId(item)).with { "item/$it" }
    }

    // Blocks
    fun <T : Block> register(
        block: T,
        id: Location,
        group: ItemGroup? = null,
    ): T {
        if (group != null)
            ItemGroupEvents.modifyEntriesEvent(group)
                .register(ItemGroupEvents.ModifyEntries { entries -> entries.add(block) })

        Registry.register(Registries.ITEM, id, BlockItem(block, Item.Settings()))
        return Registry.register(Registries.BLOCK, id, block)
    }

    fun <T : Block> getBlocks(
        clazz: KClass<out T>
    ): List<T> {
        return Registries.BLOCK.streamEntries().map { it.value() }.filter { clazz.isInstance(it) }.map { it as T }.toList()
    }

    fun getId(block: Block): Location {
        return Location(Registries.BLOCK.getId(block)).with { "block/$it" }
    }

    // ItemGroups
    fun register(
        id: Location,
        icon: ItemConvertible
    ): ItemGroup {
        return FabricItemGroup.builder(id).icon { ItemStack(icon) }.build()
    }

    fun getId(group: ItemGroup): Location {
        return Location(group.id)
    }

    // Recipes
    fun register(
        id: Location,
        recipeType: RecipeType<*>,
        recipeSerializer: RecipeSerializer<*>,
    ) {
        Registry.register(Registries.RECIPE_SERIALIZER, id, recipeSerializer)
        Registry.register(Registries.RECIPE_TYPE, id, recipeType)
    }
}