package com.rhseung.abstractlib.render.tooltip

import com.rhseung.abstractlib.api.math.Vector2d
import com.rhseung.abstractlib.render.Color
import net.minecraft.client.font.TextRenderer
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.screen.ingame.EnchantmentScreen
import net.minecraft.client.gui.screen.ingame.FurnaceScreen
import net.minecraft.client.gui.tooltip.TooltipComponent
import net.minecraft.client.item.TooltipData
import kotlin.reflect.full.primaryConstructor

abstract class AbstractTooltipComponent(
    open val data: TooltipData,
    open val screen: Screen? = null
) : TooltipComponent {

    fun setScreen(screen: Screen): AbstractTooltipComponent {
        return this::class.primaryConstructor!!.call(data, screen)
    }
    
    open fun draw(handler: TooltipHandler) {
        
        /**
         * todo: [TooltipHandler] 구현하면 바꾸기
         * ```
         * handler.draw(handler.builder {
         *     case (EnchantmentScreen::class) {
         *         "[Enchant] **Level** is ${data.enchantmentLevel}."
         *     }
         *     case (FurnaceScreen::class) {
         *         + "[Fire] [Burn time] is ${data.burnTime} ticks.".putElement(Icon.FIRE, Color.RED)
         *     }
         *     default {
         *         + "[Durability] [${data.currentDurability}][/${data.maxDurability}]"
         *             .putElement(Icon.DURABILITY, Color.WHITE, Color.GRAY)
         *         + "[Damage] [${data.damage}][/${data.maxDamage}]"
         *             .putElement(Icon.DAMAGE, Color.WHITE, Color.GRAY)
         *     }
         * })
         * ```
         */
    }

    /**
     * todo: TooltipHandler의 구조를 고민하기
     */
//    open val tooltip = TooltipHandler()

    override fun getHeight(): Int {
        return 0
//        return tooltip.getHeight(screen)
    }

    override fun getWidth(textRenderer: TextRenderer): Int {
        return 0
//        return tooltip.getWidth(textRenderer, screen)
    }

    override fun drawItems(textRenderer: TextRenderer, x: Int, y: Int, context: DrawContext) {
        draw(TooltipHandler(textRenderer, context, Vector2d(x, y)))
    }
}