package com.rhseung.abstractlib.data.example

import com.rhseung.abstractlib.data.AbstractBlockLootTableProvider
import com.rhseung.abstractlib.data.BlockLootTableHandler
import com.rhseung.abstractlib.data.BlockLootTableHandler.Companion.counts
import com.rhseung.abstractlib.data.BlockLootTableHandler.Companion.drop
import com.rhseung.abstractlib.data.BlockLootTableHandler.Companion.dropSelf
import com.rhseung.abstractlib.data.BlockLootTableHandler.Companion.loop
import com.rhseung.abstractlib.registration.Register
import com.rhseung.abstractlib.registration.key.BasicBlock
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.block.Blocks
import net.minecraft.data.server.loottable.BlockLootTableGenerator
import net.minecraft.item.Items

class ModBlockLootTableProvider(
    override val output: FabricDataOutput,
) : AbstractBlockLootTableProvider(output) {

    override fun register(blockLootTable: BlockLootTableHandler) {
        blockLootTable += loop(Register.Block.BLOCK) { dropSelf(it) }
    }
}