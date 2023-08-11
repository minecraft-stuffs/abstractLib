package com.rhseung.abstractlib.registration.example

import com.rhseung.abstractlib.api.annotation.Lang
import com.rhseung.abstractlib.registration.key.IRegistryKey

interface IModInit {
    /**
     * Update [IRegistryKey.langs] changed by [Lang] annotations.
     */
    fun register() {
        this::class.java.declaredFields
            .filterNot { it.name == "INSTANCE" }
            .forEach { field ->
                field.annotations.forEach { annotation ->
                    if (annotation is Lang) {
                        val language = annotation.language
                        val translation = annotation.translation
                        val key = field.get(this) as IRegistryKey

                        key.langs[language] = translation
                    }
                }
            }
    }
}