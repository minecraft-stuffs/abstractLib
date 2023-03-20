package com.rhseung.abstractlib.api.file

import net.minecraft.util.Identifier

data class Location(
    val namespace: String,
    val path: String
): Identifier(namespace, path) {
    constructor(path: String): this("minecraft", path)
    constructor(id: Identifier): this(id.namespace, id.path)

    companion object {
        fun Location.with(change: (String) -> String) = Location(namespace, change(path))
        operator fun Location.plus(postfix: String) = this.with { it + postfix }
        operator fun String.plus(location: Location) = location.with { this + it }
    }
}