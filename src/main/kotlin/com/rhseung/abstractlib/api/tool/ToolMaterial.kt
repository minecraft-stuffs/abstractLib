package com.rhseung.abstractlib.api.tool

import net.minecraft.item.Items
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.tag.ItemTags

data class ToolMaterial(
    val toolTier: Int,
    val durability: Int,
    val miningSpeed: Float,
    val attackDamage: Float,
    val enchantability: Int,
    val repairIngredient: Ingredient
) {
    companion object {
        val WOOD = ToolMaterial(0, 59, 2.0f, 0.0f, 15, Ingredient.fromTag(ItemTags.PLANKS))
        val STONE = ToolMaterial(1, 131, 4.0f, 1.0f, 5, Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS))
        val IRON = ToolMaterial(2, 250, 6.0f, 2.0f, 14, Ingredient.ofItems(Items.IRON_INGOT))
        val DIAMOND = ToolMaterial(3, 1561, 8.0f, 3.0f, 10, Ingredient.ofItems(Items.DIAMOND))
        val GOLD = ToolMaterial(0, 32, 12.0f, 0.0f, 22, Ingredient.ofItems(Items.GOLD_INGOT))
        val NETHERITE = ToolMaterial(4, 2031, 9.0f, 4.0f, 15, Ingredient.ofItems(Items.NETHERITE_INGOT))
    }
}