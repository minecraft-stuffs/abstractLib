package com.rhseung.abstractlib.data.example

import com.rhseung.abstractlib.data.AbstractModelProvider
import com.rhseung.abstractlib.data.BlockModelHandler
import com.rhseung.abstractlib.data.ItemModelHandler
import com.rhseung.abstractlib.registration.Register
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput

class ModModelProvider(
    output: FabricDataOutput
) : AbstractModelProvider(output) {

    override fun registerItem(itemModel: ItemModelHandler) {
        // todo: i hate this code, but we need modid in the path
//        itemModel += itemModel.simple()
//        itemModel += itemModel.loop(Register.item.ITEM) { itemModel.simple(it) }
    }

    override fun registerBlock(blockModel: BlockModelHandler) {
//        Register.loopBlock {
//            blockModel.simple(it)
//        }
    }
}