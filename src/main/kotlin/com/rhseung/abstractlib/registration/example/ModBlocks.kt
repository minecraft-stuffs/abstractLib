package com.rhseung.abstractlib.registration.example

import com.rhseung.abstractlib.api.ToolType
import com.rhseung.abstractlib.registration.MyRegistry.BLOCKS

object ModBlocks : IModInit {
    val EXAMPLE_BLOCK = BLOCKS.register("example_block") {
        luminance { 15 }
        resistance { 15.0f }
        hardness { 5.0f }
        requiredToolLevel { ToolType.PICKAXE(2) }
        itemGroup { ModItemGroups.TOOLS }
    }
}