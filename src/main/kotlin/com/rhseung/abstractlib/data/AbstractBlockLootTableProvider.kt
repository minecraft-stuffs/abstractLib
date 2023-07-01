package com.rhseung.abstractlib.data

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider

abstract class AbstractBlockLootTableProvider(
    open val output: FabricDataOutput
) : FabricBlockLootTableProvider(output) {

    override fun generate() {
        val handler = BlockLootTableHandler(output.modId, this)
        register(handler)
    }

    open fun register(handler: BlockLootTableHandler) {}
}