package com.rhseung.abstractlib.data.example

import com.rhseung.abstractlib.data.AbstractBlockLootTableProvider
import com.rhseung.abstractlib.data.BlockLootTableHandler
import com.rhseung.abstractlib.data.BlockLootTableHandler.Companion.dropSelf
import com.rhseung.abstractlib.registration.MyRegistry
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput

class ModBlockLootTableProvider(
    override val output: FabricDataOutput,
) : AbstractBlockLootTableProvider(output) {

    override fun register(blockLootTable: BlockLootTableHandler) {
        MyRegistry.BLOCKS.forEach { blockLootTable += dropSelf(it) }
    }
}