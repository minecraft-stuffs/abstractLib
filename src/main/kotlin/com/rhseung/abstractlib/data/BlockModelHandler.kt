package com.rhseung.abstractlib.data

import com.rhseung.abstractlib.registration.key.Block
import net.minecraft.data.client.BlockStateModelGenerator

class BlockModelHandler(
    val modId: String,
    val generator: BlockStateModelGenerator
) {
    fun simple(block: Block) {
        generator.registerSimpleCubeAll(block)
    }

    // note: builder는 일단 내가 blockstate 문법을 몰라서 이해하면 만들자
}