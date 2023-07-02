package com.rhseung.abstractlib.api.file

import net.minecraft.util.Identifier

class Location(
    namespace: String,
    path: String
) : Identifier(namespace, path) {

    constructor(path: String): this("minecraft", path)
    constructor(id: Identifier): this(id.namespace, id.path)

    override fun toString(): String {
        return "$namespace:$path"
    }

    companion object {
        fun Location.with(change: (String) -> String) = Location(namespace, change(path))
        operator fun Location.plus(postfix: String) = this.with { it + postfix }
        operator fun String.plus(location: Location) = location.with { this + it }
        infix fun String.of(modId: String) = Location(modId, this)
    }
}