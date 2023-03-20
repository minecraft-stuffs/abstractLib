package com.rhseung.abstractlib.api.registration.registrykeys

import com.rhseung.abstractlib.api.tool.ToolMaterial
import com.rhseung.abstractlib.api.tool.ToolType
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.resource.featuretoggle.FeatureFlag
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity

class BasicTool private constructor(
    val id: Identifier,
    val setting: Settings,
    val toolType: ToolType,
    val toolMaterial: ToolMaterial,
) : Item(setting.settings.maxDamageIfAbsent(toolMaterial.durability)), IBasicRegistryKey {

    override fun getEnchantability(): Int {
        return toolMaterial.enchantability
    }

    override fun canRepair(stack: ItemStack, ingredient: ItemStack): Boolean {
        return toolMaterial.repairIngredient.test(ingredient) || super.canRepair(stack, ingredient)
    }

    companion object {
        fun of(modId: String, lambda: ToolBuilder.() -> Unit) = ToolBuilder(modId).apply(lambda).build()
    }

    class ToolBuilder(val modId: String) {
        var path = ""
        lateinit var toolMaterial: ToolMaterial
        lateinit var toolType: ToolType
        private lateinit var settings: Settings

        fun settings(lambda: SettingsBuilder.() -> Unit): ToolBuilder {
            this.settings = SettingsBuilder().apply(lambda).build()
            return this
        }

        fun build() = BasicTool(Identifier(modId, path), settings, toolType, toolMaterial)
    }

    class SettingsBuilder {
        var group: ItemGroup? = null
        var maxCount: Int = 64
        var maxDamage: Int = 0
        var recipeRemainder: Item? = null
        var rarity: Rarity = Rarity.COMMON
        var fireproof: Boolean = false
        var requireFeatures: Array<out FeatureFlag> = arrayOf()

        fun build(): Settings {
            var settings = Settings().settings
                .maxCount(maxCount)
                .maxDamage(maxDamage)
                .recipeRemainder(recipeRemainder)
                .rarity(rarity)

            if (requireFeatures.isNotEmpty()) settings = settings.requires(*requireFeatures)
            if (fireproof) settings = settings.fireproof()

            return Settings(settings, group)
        }
    }

    data class Settings(val settings: Item.Settings = Item.Settings(), val group: ItemGroup? = null)
}