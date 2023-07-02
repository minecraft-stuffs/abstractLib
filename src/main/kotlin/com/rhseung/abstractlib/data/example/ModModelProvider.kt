package com.rhseung.abstractlib.data.example

import com.rhseung.abstractlib.data.AbstractModelProvider
import com.rhseung.abstractlib.data.BlockModelHandler
import com.rhseung.abstractlib.data.ItemModelHandler
import com.rhseung.abstractlib.registration.BasicBlock
import com.rhseung.abstractlib.registration.Register
import com.rhseung.abstractlib.init.example.ModInit
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput

class ModModelProvider(
    output: FabricDataOutput
) : AbstractModelProvider(output) {

    override fun registerItem(handler: ItemModelHandler) {
        handler.simple(ModInit.BRASS_INGOT)
    }

    override fun registerBlock(handler: BlockModelHandler) {
        Register.getBlocks(BasicBlock::class).forEach { block ->
            handler.simple(block)
        }
    }
}