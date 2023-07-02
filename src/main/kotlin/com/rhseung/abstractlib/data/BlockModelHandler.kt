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

    // note: builder는 일단 내가 blockstate 문법을 몰라서 이해하면 만들자
}