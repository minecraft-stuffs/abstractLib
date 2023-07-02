package com.rhseung.abstractlib.api

data class URI(
    val path: String
) {
    companion object {
        operator fun URI.div(other: URI) = URI("${this.path}/${other.path}")
    }
}