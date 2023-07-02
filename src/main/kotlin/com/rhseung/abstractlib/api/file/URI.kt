package com.rhseung.abstractlib.api.file

data class URI(
    val path: String
) {
    companion object {
        operator fun URI.div(other: URI) = URI("${this.path}/${other.path}")
        operator fun URI.div(other: String) = URI("${this.path}/$other")
        operator fun String.div(other: URI) = URI("$this/${other.path}")
    }
}