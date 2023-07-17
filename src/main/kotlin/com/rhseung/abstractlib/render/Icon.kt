package com.rhseung.abstractlib.render

import com.rhseung.abstractlib.api.file.path.URI.Companion.div
import com.rhseung.abstractlib.api.file.path.URI.Companion.gui
import com.rhseung.abstractlib.api.file.path.URI.Companion.icon
import com.rhseung.abstractlib.api.file.path.URI.Companion.textures
import com.rhseung.abstractlib.api.math.Size2d
import com.rhseung.abstractlib.api.math.Vector2d
import kotlin.math.floor

class Icon(
	val name: String,
	val iconSize: Size2d,   // 각 아이콘의 크기
	private val variants: Int = 1
) {
	val path = textures /gui /icon /name
	val imageSize = Size2d(iconSize.width * variants, iconSize.height) // variants를 모두 포함한 원본 사진 크기
	
	private fun index(ratio: Double): Int {
		check(ratio in 0.0..1.0)
		
		return when (ratio) {
			1.0 -> variants - 1
			else -> floor(ratio * variants).toInt()
		}
	}
	operator fun get(ratio: Double) = Vector2d(iconSize.width * index(ratio), 0)
	
	// note: 이건 glance에서
//	companion object {
//		val ATTACK_DAMAGE = Icon("attack_damage", Size2d(9, 9))
//		val ATTACK_SPEED = Icon("attack_speed", Size2d(9, 9))
//		val ATTACK_KNOCKBACK = Icon("attack_knockback", Size2d(9, 9))
//		val DURABILITY = Icon("durability", Size2d(9, 9))
//		val FIRE = Icon("fire", Size2d(9, 9))
//		val HUNGER = Icon("hunger", Size2d(9, 9), 2)
//		val SATURATION = Icon("saturation", Size2d(9, 9), 4)
//		val PROTECTION = Icon("protection", Size2d(9, 9))
//		val TOUGHNESS = Icon("toughness", Size2d(9, 9))
//		val KNOCKBACK_RESISTANCE = Icon("knockback_resistance", Size2d(9, 9))
//		val LUCK = Icon("luck", Size2d(9, 9))
//		val MAX_HEALTH = Icon("max_health", Size2d(9, 9))
//		val SPEED = Icon("speed", Size2d(9, 9))
//		val ENCHANTED = Icon("enchanted", Size2d(9, 9))
//		val POSITIVE = Icon("positive", Size2d(9, 9))
//		val NEGATIVE = Icon("negative", Size2d(9, 9))
//	}
}