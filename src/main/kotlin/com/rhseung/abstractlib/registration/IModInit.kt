package com.rhseung.abstractlib.registration

import com.rhseung.abstractlib.Mod
import com.rhseung.abstractlib.api.utility.ErrorSolver.npe
import com.rhseung.abstractlib.registration.key.IBasicRegistryKey
import kotlin.reflect.full.declaredMemberProperties

interface IModInit<T: IBasicRegistryKey> {
    fun update() {
        this::class.java.declaredFields.filterNot { it.name == "INSTANCE" }.forEach { field ->
            field.annotations.forEach { annotation ->
                val isLangAnnotation = Regex("[a-z]{2}_[a-z]{2}")
                val annotationClass = annotation.annotationClass
                val annotationName = annotationClass.simpleName!!

                if (isLangAnnotation.find(annotationName) != null) {  // 언어 코드인지 확인
                    val valueProperty = annotationClass.declaredMemberProperties
                        .find { it.name == "value" }
                        ?: npe("`value` property is not found in $annotationName annotation")
                    val value = valueProperty.call(annotation) as String

                    @Suppress("UNCHECKED_CAST")
                    (field.get(this) as T).names[annotationClass] = value
                }
            }
        }
    }

    fun register() {
//        update()
//        MyRegister<T>().forEach { Registries
    }
}