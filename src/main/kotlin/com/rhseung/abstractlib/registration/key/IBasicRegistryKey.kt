package com.rhseung.abstractlib.registration.key

import com.rhseung.abstractlib.api.file.path.Location
import com.rhseung.abstractlib.api.utility.ErrorSolver.npe
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties

interface IBasicRegistryKey {
    val id: Location

    // note: 어노테이션은 item.create 같은 함수에 붙고, 정작 init은 그 함수의 구동 코드 내부에 존재해서 어노테이션들이 제대로 딸려올지 않을 것 같음
    //  - 그럴 경우, [IModInit]의 update()를 사용
    fun langUpdate() {
        this::class.annotations.forEach { annotation ->
            val isLangAnnotation = Regex("[a-z]{2}_[a-z]{2}")
            val annotationClass = annotation.annotationClass
            val annotationName = annotationClass.simpleName!!

            if (isLangAnnotation.find(annotationName) != null) {  // 언어 코드인지 확인
                val valueProperty = annotationClass.declaredMemberProperties
                    .find { it.name == "value" }
                    ?: npe("`value` property is not found in $annotationName annotation")
                val value = valueProperty.call(annotation) as String

                names[annotationClass] = value
            }
        }
    }

    // MutableMap<KClass<language annotations...>, String>
    val names: MutableMap<KClass<*>, String>

    // data class로 만들 생각이였으나, data class는 open class가 될 수 없어서 따로 toString 구현
    // 어차피 componentN은 필요 없기도 함
    override fun toString(): String
}