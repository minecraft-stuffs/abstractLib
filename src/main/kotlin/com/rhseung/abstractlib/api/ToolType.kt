package com.rhseung.abstractlib.api

data class ToolType(
    val name: String
) {
    companion object {
        val ANY = ToolType("any")
        val AXE = ToolType("axe")
        val HOE = ToolType("hoe")
        val PICKAXE = ToolType("pickaxe")
        val SHOVEL = ToolType("shovel")
    }
}