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
        // todo: 조금 수정
        itemModel += itemModel.loop(Register.Item.ITEM) { itemModel.simple(it) }
    }

    override fun registerBlock(blockModel: BlockModelHandler) {
        Register.loopBlock {
            blockModel.simple(it)
        }
    }
}