package com.rhseung.abstractlib.api.math

class PositiveInt private constructor(val value: Int): NumericSet {
    companion object {
        fun of(value: Int): PositiveInt? {
            return if (value > 0) PositiveInt(value) else null
        }

        fun getSet
    }

    operator fun plus(other: PositiveInt): PositiveInt {
        return PositiveInt.of(this.value + other.value)!!
    }

    operator fun minus(other: PositiveInt): PositiveInt {
        return PositiveInt.of(this.value - other.value)!!
    }

    operator fun times(other: PositiveInt): PositiveInt {
        return PositiveInt.of(this.value * other.value)!!
    }

    operator fun div(other: PositiveInt): PositiveInt {
        return PositiveInt.of(this.value / other.value)!!
    }

    operator fun rem(other: PositiveInt): PositiveInt {
        return PositiveInt.of(this.value % other.value)!!
    }

    operator fun compareTo(other: PositiveInt): Int {
        return this.value.compareTo(other.value)
    }

    operator fun unaryMinus(): PositiveInt {
        return PositiveInt.of(-this.value)!!
    }

    operator fun inc(): PositiveInt {
        return PositiveInt.of(this.value + 1)!!
    }

    operator fun dec(): PositiveInt {
        return PositiveInt.of(this.value - 1)!!
    }

    operator fun rangeTo(other: PositiveInt): IntRange {
        return this.value..other.value
    }

    operator fun contains(other: PositiveInt): Boolean {
        return this.value <= other.value
    }

    operator fun contains(other: Int): Boolean {
        return this.value <= other
    }

    override fun toString(): String {
        return "PositiveInt(value=$value)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PositiveInt) return false

        if (value != other.value) return false

        return true
    }
}