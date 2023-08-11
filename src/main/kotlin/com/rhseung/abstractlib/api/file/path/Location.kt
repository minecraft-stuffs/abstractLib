package com.rhseung.abstractlib.api.file.path

import net.minecraft.util.Identifier

class Location(
    namespace: String,
    path: String
) : Identifier(namespace, path) {
    constructor(path: String): this("minecraft", path)
    constructor(id: Identifier): this(id.namespace, id.path)

    override fun toString() = "$namespace:$path"

    companion object {
        fun of(path: String) = Location(URI.getModId(), path)

        infix fun String.of(modId: String) = Location(modId, this)

        fun Location.with(change: (String) -> String) = Location(namespace, change(path))
        operator fun Location.plus(postfix: String) = this.with { it + postfix }
    }
}