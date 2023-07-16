package com.rhseung.abstractlib.render.tooltip

import com.rhseung.abstractlib.api.math.Vector2d
import com.rhseung.abstractlib.render.Icon
import net.minecraft.client.font.TextRenderer
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import kotlin.reflect.KClass

//typealias Lines = MutableMap<KClass<out Screen>, TooltipHandler.Line>

/**
 * note: [TooltipHandler] 구조를 고민하기
 *  - [Screen]에 따라 다른 tooltip이 나오도록 하기
 *  - 아이콘과 텍스트의 조화가 아닌, 완전히 딴판인 tooltip을 만들 수 있도록 하기
 *      - map tooltip: 지도를 보여줌
 *      - bundle, shulker chest tooltip: 내용물을 inventory slot으로 보여줌
 *
 * todo: 구현 전에 선행으로 해야할 것
 *  - 일단 [DrawContext] 사용해보기
 *
 * idea: tkinter 처럼, tooltip을 구성하는 위젯을 만들고, 이를 조합하여 tooltip을 만들 수 있도록 하기
 */
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