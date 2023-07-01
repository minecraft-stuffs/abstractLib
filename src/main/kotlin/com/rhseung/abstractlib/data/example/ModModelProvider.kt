package com.rhseung.abstractlib.data.example

import com.rhseung.abstractlib.data.AbstractModelProvider
import com.rhseung.abstractlib.data.BlockModelHandler
import com.rhseung.abstractlib.data.ItemModelHandler
import com.rhseung.abstractlib.init.example.ExampleInit
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput

class ModModelProvider(
    output: FabricDataOutput
) : AbstractModelProvider(output) {

    override fun registerItem(handler: ItemModelHandler) {
        handler.simple(ExampleInit.EXAMPLE_INGOT)
    }

    override fun registerBlock(handler: BlockModelHandler) {
        handler.simple(ExampleInit.EXAMPLE_BLOCK)
    }
}