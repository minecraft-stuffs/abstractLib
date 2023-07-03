package com.rhseung.abstractlib.registration

import kotlin.reflect.KClass

interface IBasicRegistryKey {
    var translationName: MutableMap<KClass<*>, String>

    override fun toString(): String
}