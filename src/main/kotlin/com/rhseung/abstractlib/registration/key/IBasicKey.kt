package com.rhseung.abstractlib.registration.key

import kotlin.reflect.KClass

interface IBasicKey {
    // MutableMap<KClass<language annotations...>, String>
    val names: MutableMap<KClass<*>, String>

    override fun toString(): String
}