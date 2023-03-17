package com.rhseung.abstractlib.api.math

class NumericSet<T: Number>(val seed: T, val sequenceGenerator: (T) -> T) {
    val sequence = generateSequence(seed, sequenceGenerator)

    infix fun union(other: NumericSet<T>): NumericSet<T> {
        val x = this.sequence + other.sequence
        return NumericSet(this.sequence + other.sequence)
    }

    // intersect infix 함수
    infix fun intersect(other: NumericSet): NumericSet {
        return NumericSet(this.sequence.intersect(other.sequence))
    }

    infix fun minus(other: NumericSet): NumericSet {
        return NumericSet(this.sequence - other.sequence)
    }

    operator fun times(other: NumericSet): NumericSet {
        return NumericSet(this.sequence * other.sequence)
    }

    operator fun div(other: NumericSet): NumericSet {
        return NumericSet(this.sequence / other.sequence)
    }

    operator fun rem(other: NumericSet): NumericSet {
        return NumericSet(this.sequence % other.sequence)
    }

    operator fun compareTo(other: NumericSet): Int {
        return this.sequence.compareTo(other.sequence)
    }

    operator fun unaryMinus(): NumericSet {
        return NumericSet(-this.sequence)
    }

    operator fun inc(): NumericSet {
        return NumericSet(this.sequence + 1)
    }

    operator fun dec(): NumericSet {
        return NumericSet(this.sequence - 1)
    }

    operator fun rangeTo(other: NumericSet): Sequence<Number> {
        return this.sequence..other.sequence
    }

    operator fun contains(other: NumericSet): Boolean {
        return this.sequence <= other.sequence
    }

    operator fun contains(other: Number): Boolean {
        return this.sequence <= other
    }

    override fun toString(): String {
        return "NumericSet(sequence=$sequence)"
    }
}