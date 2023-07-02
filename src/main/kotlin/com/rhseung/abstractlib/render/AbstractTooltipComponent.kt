package com.rhseung.abstractlib.render

import com.rhseung.abstractlib.api.math.Vector2d
import net.minecraft.client.font.TextRenderer
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
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

    /**
     * todo: [TooltipHandler] 구현하면 바꾸기
     */
    open val tooltip = 3

    override fun getHeight(): Int {
        return tooltip.getHeight(screen)
    }

    override fun getWidth(textRenderer: TextRenderer): Int {
        return tooltip.getWidth(textRenderer, screen)
    }

    override fun drawItems(textRenderer: TextRenderer, x: Int, y: Int, context: DrawContext) {
        tooltip.draw(textRenderer, context, Vector2d(x, y))
    }
}