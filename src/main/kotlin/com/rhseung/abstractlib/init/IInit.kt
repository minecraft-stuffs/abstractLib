package com.rhseung.abstractlib.init

import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.api.annotation.ko_kr
import com.rhseung.abstractlib.registration.IBasicRegistryKey

interface IInit {
    fun register() {
        this::class.java.declaredFields.filter { it.name != "INSTANCE" }.forEach { field ->
            field.isAccessible = true
            field.annotations.forEach { annotation ->
                if (Regex("[a-z]{2}_[a-z]{2}").find(annotation::class.simpleName!!) != null) {  // 언어 코드인지 확인
                    (field.get(this) as IBasicRegistryKey).translationName[annotation::class] =
                        annotation::class.java.getMethod("value").invoke(annotation) as String
                }
            }
        }
    }
}