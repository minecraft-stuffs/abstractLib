package com.rhseung.abstractlib.api.math

import kotlin.math.sqrt

data class Vector2d(val x: Int, val y: Int) {
    operator fun plus(other: Vector2d): Vector2d {
        return Vector2d(x + other.x, y + other.y)
    }

    operator fun minus(other: Vector2d): Vector2d {
        return Vector2d(x - other.x, y - other.y)
    }

    operator fun times(other: Vector2d): Int {
        return x * other.x + y * other.y
    }

    operator fun times(other: Int): Vector2d {
        return Vector2d(x * other, y * other)
    }

    companion object {
        operator fun Int.times(vector: Vector2d): Vector2d {
            return Vector2d(vector.x * this, vector.y * this)
        }
    }

    operator fun div(other: Int): Vector2d {
        return Vector2d(x / other, y / other)
    }

    operator fun rem(other: Int): Vector2d {
        return Vector2d(x % other, y % other)
    }

    operator fun unaryMinus(): Vector2d {
        return Vector2d(-x, -y)
    }

    operator fun unaryPlus(): Vector2d {
        return Vector2d(x, y)
    }

    fun abs(): Float {
        return sqrt((x * x + y * y).toFloat())
    }

    fun dist(other: Vector2d): Float {
        return (this - other).abs()
    }
}