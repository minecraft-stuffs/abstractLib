package com.rhseung.abstractlib.init

import com.rhseung.abstractlib.api.annotation.en_us
import com.rhseung.abstractlib.api.annotation.ko_kr
import com.rhseung.abstractlib.api.utility.ErrorSolver.npe
import com.rhseung.abstractlib.registration.IBasicRegistryKey
import kotlin.reflect.cast
import kotlin.reflect.full.declaredMemberProperties

interface IInit {
    fun register() {
        this::class.java.declaredFields.filter { it.name != "INSTANCE" }.forEach { field ->
            field.isAccessible = true
            
            field.annotations.forEach { annotation ->
                val annotationClassName = annotation.annotationClass.simpleName!!
                
                if (Regex("[a-z]{2}_[a-z]{2}").find(annotationClassName) != null) {  // 언어 코드인지 확인
                    val property = annotation.annotationClass.declaredMemberProperties.find { it.name == "value" } ?: npe("value is not found in $annotationClassName")
                    
                    (field.get(this) as IBasicRegistryKey).translationName[annotation.annotationClass] = property.call(annotation) as String
                }
            }
        }
    }
}