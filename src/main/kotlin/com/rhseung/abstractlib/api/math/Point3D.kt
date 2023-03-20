package com.rhseung.abstractlib.api.math

import com.rhseung.abstractlib.api.math.Math.pow
import com.rhseung.abstractlib.api.math.Math.sumOfDouble
import com.rhseung.abstractlib.api.math.Math.sumOfFloat
import com.rhseung.abstractlib.api.math.Math.sumOfInt
import kotlin.math.pow

data class Point3D<T : Number>(var x: T, var y: T, var z: T) {
	
	fun toList(): List<T> {
		return listOf(x, y, z)
	}
	
	companion object {
		fun abs(p: Point3D<Int>): Int {
			val list = p.toList()
			return sumOfInt(0 until list.count()) { i -> list[i].pow(2) }
		}
		
		fun abs(p: Point3D<Float>): Float {
			val list = p.toList()
			return sumOfFloat(0 until list.count()) { i -> list[i].pow(2) }
		}
		
		fun abs(p: Point3D<Double>): Double {
			val list = p.toList()
			return sumOfDouble(0 until list.count()) { i -> list[i].pow(2) }
		}
	}
}