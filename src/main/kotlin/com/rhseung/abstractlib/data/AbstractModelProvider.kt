package com.rhseung.abstractlib.data

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator

abstract class AbstractModelProvider(
    val output: FabricDataOutput
) : FabricModelProvider(output) {

    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        val handler = BlockModelHandler(output.modId, blockStateModelGenerator)
        registerBlock(handler)
    }

    open fun registerBlock(handler: BlockModelHandler) {}

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        val handler = ItemModelHandler(output.modId, itemModelGenerator)
        registerItem(handler)
    }

    open fun registerItem(handler: ItemModelHandler) {}
}