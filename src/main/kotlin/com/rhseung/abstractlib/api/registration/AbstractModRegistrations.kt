package com.rhseung.abstractlib.api.registration

import com.rhseung.abstractlib.api.registration.registrykeys.IBasicRegistryKey

abstract class AbstractModRegistrations<T : IBasicRegistryKey>(
//    private val modid: String
) {
    open val things = listOf<T>()

    fun autoRegistering() {
//        things.forEach { thing ->
//            RegistryManager.register(thing, )
//        }
    }
}