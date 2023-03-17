package com.rhseung.abstractlib.api.tool

data class ToolType(
    val name: String,
    val stat: ToolStat,
    val interactions: Set<ToolInteraction>
) {
    companion object {
        val ANY = ToolType("any", ToolStat.ANY, setOf())
        val SWORD = ToolType("sword", ToolStat.SWORD, setOf(ToolInteraction.SWORD))
        val PICKAXE = ToolType("pickaxe", ToolStat.PICKAXE, setOf(ToolInteraction.PICKAXE))
        val AXE = ToolType("axe", ToolStat.AXE, setOf(ToolInteraction.AXE))
        val SHOVEL = ToolType("shovel", ToolStat.SHOVEL, setOf(ToolInteraction.SHOVEL))
        val HOE = ToolType("hoe", ToolStat.HOE, setOf(ToolInteraction.HOE))
    }
}