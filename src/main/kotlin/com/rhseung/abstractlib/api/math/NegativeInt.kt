package com.rhseung.abstractlib.api.math

// 0이 아닌 음의 정수만 가지는 NegativeInt 클래스
class NegativeInt private constructor(val value: Int): NumericSet {
    companion object {
        fun of(value: Int): NegativeInt? {
            return if (value < 0) NegativeInt(value) else null
        }
    }

    operator fun plus(other: NegativeInt): NegativeInt {
        return NegativeInt.of(this.value + other.value)!!
    }

    operator fun minus(other: NegativeInt): NegativeInt {
        return NegativeInt.of(this.value - other.value)!!
    }

    operator fun times(other: NegativeInt): NegativeInt {
        return NegativeInt.of(this.value * other.value)!!
    }

    operator fun div(other: NegativeInt): NegativeInt {
        return NegativeInt.of(this.value / other.value)!!
    }

    operator fun rem(other: NegativeInt): NegativeInt {
        return NegativeInt.of(this.value % other.value)!!
    }

    operator fun compareTo(other: NegativeInt): Int {
        return this.value.compareTo(other.value)
    }

    operator fun unaryMinus(): NegativeInt {
        return NegativeInt.of(-this.value)!!
    }

    operator fun inc(): NegativeInt {
        return NegativeInt.of(this.value + 1)!!
    }

    operator fun dec(): NegativeInt {
        return NegativeInt.of(this.value - 1)!!
    }

    operator fun rangeTo(other: NegativeInt): IntRange {
        return this.value..other.value
    }

    operator fun contains(other: NegativeInt): Boolean {
        return this.value <= other.value
    }

    operator fun contains(other: Int): Boolean {
        return this.value <= other
    }

    override fun toString(): String {
        return "NegativeInt(value=$value)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is NegativeInt) return false

        if (value != other.value) return false

        return true
    }
}