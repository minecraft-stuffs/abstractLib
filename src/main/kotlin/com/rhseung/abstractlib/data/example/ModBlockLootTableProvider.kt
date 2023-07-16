package com.rhseung.abstractlib.data.example

import com.rhseung.abstractlib.data.AbstractBlockLootTableProvider
import com.rhseung.abstractlib.data.BlockLootTableHandler
import com.rhseung.abstractlib.registration.BasicBlock
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput

class ModBlockLootTableProvider(
    override val output: FabricDataOutput,
) : AbstractBlockLootTableProvider(output) {

    override fun register(handler: BlockLootTableHandler) {
        Register.getBlocks(BasicBlock::class).forEach { block ->
            handler.dropSelf(block)
        }
    }
}