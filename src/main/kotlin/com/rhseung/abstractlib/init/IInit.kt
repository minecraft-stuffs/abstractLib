package com.rhseung.abstractlib.init

import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.api.annotation.ko_kr

interface IInit {
    fun register() {
        this::class.java.declaredFields.forEach {
            if (IBasicRegistryKey::class.java.isAssignableFrom(it.type)) {
                it.annotations.forEach { annotation ->
                    when (annotation) {
                        is en_us -> (it.get(this) as IBasicRegistryKey).translationName.en_us = annotation.value
                        is ko_kr -> (it.get(this) as IBasicRegistryKey).translationName.ko_kr = annotation.value
                    }
                }
            }
        }
    }
}