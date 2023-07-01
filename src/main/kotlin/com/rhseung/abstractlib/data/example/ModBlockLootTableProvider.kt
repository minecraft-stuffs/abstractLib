package com.rhseung.abstractlib.data.example

import com.rhseung.abstractlib.data.AbstractBlockLootTableProvider
import com.rhseung.abstractlib.data.BlockLootTableHandler
import com.rhseung.abstractlib.data.BlockLootTableHandler.Companion.and
import com.rhseung.abstractlib.data.BlockLootTableHandler.Companion.counts
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.block.Blocks
import net.minecraft.item.Items

class ModBlockLootTableProvider(
    override val output: FabricDataOutput,
) : AbstractBlockLootTableProvider(output) {

    override fun register(handler: BlockLootTableHandler) {
//        handler.builder(this) {
//            from { Blocks.NETHERITE_BLOCK }
//
//            case (BlockLootTableHandler.Condition.SILK_TOUCH) {
//                drop { Items.NETHERITE_BLOCK }
//            }
//            default {
//                drops { Items.NETHERITE_INGOT counts 3..9 }
//                applyFortune { true }
//            }
//        }
    }
}