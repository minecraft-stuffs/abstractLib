package com.rhseung.abstractlib.render.tooltip

import com.rhseung.abstractlib.api.math.Vector2d
import com.rhseung.abstractlib.render.Icon
import net.minecraft.client.font.TextRenderer
import net.minecraft.client.gui.DrawContext
import net.minecraft.client.gui.screen.Screen
import kotlin.reflect.KClass

/**
 * note: [TooltipHandler] 구조를 고민하기
 *  - [Screen]에 따라 다른 tooltip이 나오도록 하기
 *  - 아이콘과 텍스트의 조화가 아닌, 완전히 딴판인 tooltip을 만들 수 있도록 하기
 *      - map tooltip: 지도를 보여줌
 *      - bundle, shulker chest tooltip: 내용물을 inventory slot으로 보여줌
 *  - tkinter 처럼, tooltip을 구성하는 위젯을 만들고, 이를 조합하여 tooltip을 만들 수 있도록 하기
 *
 * todo: 구현 전에 선행으로 해야할 것
 *  - 일단 [DrawContext] 사용해보기
 */
class TooltipHandler(
    val textRenderer: TextRenderer, val context: DrawContext, val vector2d: Vector2d
) {

}

fun test(tooltipHandler: TooltipHandler) {

}