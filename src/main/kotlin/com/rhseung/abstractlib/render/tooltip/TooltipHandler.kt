package com.rhseung.abstractlib.render.tooltip

import com.rhseung.abstractlib.api.math.Vector2d
import com.rhseung.abstractlib.render.Icon
import net.minecraft.client.font.TextRenderer
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import kotlin.reflect.KClass

//typealias Lines = MutableMap<KClass<out Screen>, TooltipHandler.Line>

class TooltipHandler(
    val textRenderer: TextRenderer, val context: DrawContext, val vector2d: Vector2d
) {
//    fun getHeight(screen: Screen?): Int {
//        return 0
//    }
//
//    fun getWidth(textRenderer: TextRenderer, screen: Screen?): Int {
//        return 0
//    }
//
//    fun draw(lines: Lines) {
//
//    }
//
//    fun builder(lambda: Builder.() -> Unit): Lines {
//        return Builder().apply(lambda).build()
//    }
//
//    class Builder {
//        private val lines = mutableMapOf<KClass<out Screen>, Line>()
//
//        fun build(): Lines {
//            return lines
//        }
//    }
//
//    interface Element {
//        fun width(textRenderer: TextRenderer) = 0
//    }
//
//    class IconElement(val icon: Icon) : Element {
//        override fun width(textRenderer: TextRenderer) = icon.icon_size.width
//    }
//
//    class TextElement(val text: String) : Element {
//        override fun width(textRenderer: TextRenderer) = textRenderer.getWidth(text)
//    }
//
//    data class Line(val elements: MutableList<>)
}