package com.rhseung.abstractlib.api.tool

import net.minecraft.block.Block

class ToolTier(vararg val blocks: Block) {


    companion object {
        const val WOOD = 0
        const val STONE = 1
        const val IRON = 2
        const val DIAMOND = 3
        const val NETHERITE = 4
    }
}