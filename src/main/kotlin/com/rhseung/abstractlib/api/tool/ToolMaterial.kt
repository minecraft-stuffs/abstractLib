package com.rhseung.abstractlib.api.tool

data class ToolMaterial(
    val toolTier: Int,
    val durability: Int,
    val miningSpeed: Float,
    val attackDamage: Float,
    val enchantability: Int
) {
    companion object {
        val WOOD = ToolMaterial(0, 59, 2.0f, 0.0f, 15)
        val STONE = ToolMaterial(1, 131, 4.0f, 1.0f, 5)
        val IRON = ToolMaterial(2, 250, 6.0f, 2.0f, 14)
        val DIAMOND = ToolMaterial(3, 1561, 8.0f, 3.0f, 10)
        val GOLD = ToolMaterial(0, 32, 12.0f, 0.0f, 22)
    }
}