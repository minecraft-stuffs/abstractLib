package com.rhseung.abstractlib.init

import com.rhseung.abstractlib.api.Location
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey

class Register {
    companion object {
        fun item(loc: Location, lambda: ItemBuilder.() -> Unit): BasicItem {
            return ItemBuilder(loc).apply(lambda).build()
        }

        fun block(loc: Location, lambda: BlockBuilder.() -> Unit): BasicBlock {
            return BlockBuilder(loc).apply(lambda).build()
        }
    }

    class ItemBuilder(val loc: Location) {
        var group: RegistryKey<ItemGroup>? = null
        var setting = Item.Settings()

        fun build(): BasicItem {
            val ret = BasicItem(loc, setting)

            if (group != null) {
                ItemGroupEvents.modifyEntriesEvent(group)
                    .register(ItemGroupEvents.ModifyEntries { entries -> entries.add(ret) })
            }

            return Registry.register(Registries.ITEM, loc, ret)
        }
    }

    class BlockBuilder(val loc: Location) {
        var group: RegistryKey<ItemGroup>? = null
        var setting = AbstractBlock.Settings.create()

        fun build(): BasicBlock {
            val ret = BasicBlock(loc, setting)
            val blockItem = BlockItem(ret, Item.Settings())

            if (group != null) {
                ItemGroupEvents.modifyEntriesEvent(group)
                    .register(ItemGroupEvents.ModifyEntries { entries -> entries.add(blockItem) })
            }

            Registry.register(Registries.ITEM, loc, blockItem)
            return Registry.register(Registries.BLOCK, loc, ret)
        }
    }
}