package com.rhseung.abstractlib.api

object StringStyle {
    fun String.titlecase()
        = this.lowercase().split("_").joinToString(" ") { it.replaceFirstChar { it.titlecase() } }
}