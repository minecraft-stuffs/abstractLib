package com.rhseung.abstractlib.data

import com.rhseung.abstractlib.init.BasicBlock
import net.minecraft.data.client.BlockStateModelGenerator

class BlockModelHandler(
    val modId: String,
    val generator: BlockStateModelGenerator
) {
    fun simple(block: BasicBlock) {
        generator.registerSimpleCubeAll(block)
    }
}