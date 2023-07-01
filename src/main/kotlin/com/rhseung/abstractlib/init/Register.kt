package com.rhseung.abstractlib.init

import com.rhseung.abstractlib.api.Location
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.EntityType
import net.minecraft.item.BlockItem
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.loot.LootTables
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.resource.featuretoggle.FeatureFlag
import net.minecraft.resource.featuretoggle.FeatureSet
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity
import net.minecraft.util.math.Direction
import java.util.function.ToIntFunction

class Register {
    companion object {
        fun item(loc: Location, lambda: ItemBuilder.() -> Unit): Item {
            return ItemBuilder(loc).apply(lambda).build()
        }

        fun block(loc: Location, lambda: BlockBuilder.() -> Unit): Block {
            return BlockBuilder(loc).apply(lambda).build()
        }
    }

    class ItemBuilder(val loc: Location) {
        var group: RegistryKey<ItemGroup>? = null
        var setting = Item.Settings()

        fun build(): Item {
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

        fun build(): Block {
            val ret = BasicBlock(loc, setting)
            val blockitem = BlockItem(ret, Item.Settings())

            if (group != null) {
                ItemGroupEvents.modifyEntriesEvent(group)
                    .register(ItemGroupEvents.ModifyEntries { entries -> entries.add(blockitem) })
            }

            Registry.register(Registries.ITEM, loc, blockitem)
            return Registry.register(Registries.BLOCK, loc, ret)
        }
    }
}