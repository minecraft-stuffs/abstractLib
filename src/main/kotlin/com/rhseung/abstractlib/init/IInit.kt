package com.rhseung.abstractlib.init

import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.api.annotation.ko_kr
import com.rhseung.abstractlib.registration.IBasicRegistryKey

interface IInit {
    fun register() {
        this::class.java.declaredFields.filter { it.name != "INSTANCE" }.forEach { field ->
            field.isAccessible = true
            field.annotations.forEach { when (it) {
                is en_us -> (field.get(this) as IBasicRegistryKey).translationName["en_us"] = it.value
                is ko_kr -> (field.get(this) as IBasicRegistryKey).translationName["ko_kr"] = it.value
                // todo: 다국어 지원
            } }
        }
    }
}