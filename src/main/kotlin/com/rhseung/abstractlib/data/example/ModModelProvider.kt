package com.rhseung.abstractlib.data.example

import com.rhseung.abstractlib.data.AbstractModelProvider
import com.rhseung.abstractlib.data.BlockModelHandler
import com.rhseung.abstractlib.data.ItemModelHandler
import com.rhseung.abstractlib.data.ItemModelHandler.Companion.simple
import com.rhseung.abstractlib.registration.MyRegistry
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput

class ModModelProvider(
    output: FabricDataOutput
) : AbstractModelProvider(output) {

    override fun registerItem(itemModel: ItemModelHandler) {
        MyRegistry.ITEMS.forEach { itemModel += simple(it) }
    }

    override fun registerBlock(blockModel: BlockModelHandler) {
        MyRegistry.BLOCKS.forEach { blockModel.simple(it) }
    }
}