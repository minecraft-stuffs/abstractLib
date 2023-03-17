package com.rhseung.abstractlib.api.tool

data class ToolStat(
    val attackSpeed: Float,
    val attackDamage: Float
) {
    companion object {
        val ANY = ToolStat(4.0F, 0.0F)
        val SWORD = ToolStat(1.6F, 3.0F)
        val PICKAXE = ToolStat(1.2F, 1.0F)
        val AXE = ToolStat(1.0F, 5.0F)
        val SHOVEL = ToolStat(1.0F, 1.5F)
        val HOE = ToolStat(4.0F, 0.0F)
    }
}