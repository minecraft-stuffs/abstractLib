package com.rhseung.abstractlib.registration

import kotlin.reflect.KClass

interface IBasicKey {
    // MutableMap<KClass<language annotations...>, String>
    var names: MutableMap<KClass<*>, String>

    override fun toString(): String
}