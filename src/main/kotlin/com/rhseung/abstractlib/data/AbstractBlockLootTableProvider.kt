package com.rhseung.abstractlib.data

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.data.server.loottable.BlockLootTableGenerator

abstract class AbstractBlockLootTableProvider(
    open val output: FabricDataOutput
) : FabricBlockLootTableProvider(output) {

    override fun generate() {
        val blockLootTable = BlockLootTableHandler(output.modId, this)
        register(blockLootTable)
    }

    open fun register(blockLootTable: BlockLootTableHandler) {}
}