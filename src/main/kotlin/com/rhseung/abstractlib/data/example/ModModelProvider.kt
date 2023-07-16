package com.rhseung.abstractlib.data.example

import com.rhseung.abstractlib.data.AbstractModelProvider
import com.rhseung.abstractlib.data.BlockModelHandler
import com.rhseung.abstractlib.data.ItemModelHandler
import com.rhseung.abstractlib.registration.key.BasicBlock
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput

class ModModelProvider(
    output: FabricDataOutput
) : AbstractModelProvider(output) {

    override fun registerItem(itemModel: ItemModelHandler) {
        itemModel.simple(ModInit.BRASS_INGOT)
    }

    override fun registerBlock(blockModel: BlockModelHandler) {
        Register.getBlocks(BasicBlock::class).forEach { block ->
            blockModel.simple(block)
        }
    }
}