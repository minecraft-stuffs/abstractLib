package com.rhseung.abstractlib.data.example

import com.rhseung.abstractlib.data.AbstractBlockLootTableProvider
import com.rhseung.abstractlib.data.BlockLootTableHandler
import com.rhseung.abstractlib.data.BlockLootTableHandler.Companion.unaryPlus
import com.rhseung.abstractlib.registration.Register
import com.rhseung.abstractlib.registration.key.BasicBlock
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.block.Blocks
import net.minecraft.data.server.loottable.BlockLootTableGenerator

class ModBlockLootTableProvider(
    override val output: FabricDataOutput,
) : AbstractBlockLootTableProvider(output) {

    override fun register(blockLootTable: BlockLootTableHandler) {
//        + blockLootTable.dropSelf(Blocks.AMETHYST_BLOCK)
        
        // todo: 조금 수정
        blockLootTable.adds(Register.Block.BLOCK) { block ->
            blockLootTable.dropSelf(block) }
        }
}