package com.rhseung.abstractlib.api

import com.rhseung.abstractlib.registration.ToolLevel

data class ToolType(
    val name: String
) {
    operator fun invoke(level: Int): ToolLevel {
        return ToolLevel(level, this)
    }

    companion object {
        val ANY = ToolType("any")
        val AXE = ToolType("axe")
        val HOE = ToolType("hoe")
        val PICKAXE = ToolType("pickaxe")
        val SHOVEL = ToolType("shovel")
    }
}