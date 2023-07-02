package com.rhseung.abstractlib.registration

import com.rhseung.abstractlib.api.file.Location
import com.rhseung.abstractlib.api.MiningLevel
import com.rhseung.abstractlib.api.ToolType
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import kotlin.reflect.KClass

object Register {
    infix fun MiningLevel.using(toolType: ToolType) = Pair(this, toolType)

    fun item(loc: Location, lambda: ItemBuilder.() -> Unit): BasicItem {
        return ItemBuilder(loc).apply(lambda).build()
    }

    fun block(loc: Location, lambda: BlockBuilder.() -> Unit): BasicBlock {
        return BlockBuilder(loc).apply(lambda).build()
    }

    class ItemBuilder(val loc: Location) {
        var itemGroup: RegistryKey<ItemGroup>? = null
        var setting = Item.Settings()

        fun build(): BasicItem {
            val ret = BasicItem(loc, setting)

            if (itemGroup != null) {
                ItemGroupEvents.modifyEntriesEvent(itemGroup)
                    .register(ItemGroupEvents.ModifyEntries { entries -> entries.add(ret) })
            }

            return Registry.register(Registries.ITEM, loc, ret)
        }
    }

    class BlockBuilder(val loc: Location) {
        var itemGroup: RegistryKey<ItemGroup>? = null
        var requiresTool: Pair<MiningLevel, ToolType> = MiningLevel.WOOD using ToolType.ANY
        var setting = AbstractBlock.Settings.create()

        fun build(): BasicBlock {
            if (requiresTool.second != ToolType.ANY)
                setting = setting.requiresTool()

            val ret = BasicBlock(loc, requiresTool, setting)
            val blockItem = BlockItem(ret, Item.Settings())

            if (itemGroup != null) {
                ItemGroupEvents.modifyEntriesEvent(itemGroup)
                    .register(ItemGroupEvents.ModifyEntries { entries -> entries.add(blockItem) })
            }

            Registry.register(Registries.ITEM, loc, blockItem)
            return Registry.register(Registries.BLOCK, loc, ret)
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Item> getItems(kclass: KClass<out T>): List<T> {
        return Registries.ITEM.streamEntries()
            .map { it.value() }
            .filter { kclass.isInstance(it) }
            .map { it as T }
            .toList()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Item> getItem(loc: Location): T {
        return Registries.ITEM.get(loc) as T
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Block> getBlocks(kclass: KClass<out T>): List<T> {
        return Registries.BLOCK.streamEntries()
            .map { it.value() }
            .filter { kclass.isInstance(it) }
            .map { it as T }
            .toList()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Block> getBlock(loc: Location): T {
        return Registries.BLOCK.get(loc) as T
    }
}