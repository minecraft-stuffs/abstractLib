//package com.rhseung.abstractlib.registration.old
//
//import com.rhseung.abstractlib.api.utility.ErrorSolver.npe
//import com.rhseung.abstractlib.registration.key.IRegistryKey
//import net.minecraft.registry.Registries
//import kotlin.reflect.full.companionObject
//import kotlin.reflect.full.declaredMemberProperties
//
//interface IModInit<T: IRegistryKey> {
//    /**
//     * [IRegistryKey]의 번역 테이블을 업데이트합니다.
//     */
//    fun update() {
//        this::class.java.declaredFields.filterNot { it.name == "INSTANCE" }.forEach { field ->
//            field.annotations.forEach { annotation ->
//                val isLangAnnotation = Regex("[a-z]{2}_[a-z]{2}")
//                val annotationClass = annotation.annotationClass
//                val annotationName = annotationClass.simpleName!!
//
//                if (isLangAnnotation.find(annotationName) != null) {  // 언어 코드인지 확인
//                    val valueProperty = annotationClass.declaredMemberProperties
//                        .find { it.name == "value" }
//                        ?: npe("`value` property is not found in $annotationName annotation")
//                    val value = valueProperty.call(annotation) as String
//
//                    @Suppress("UNCHECKED_CAST")
//                    (field.get(this) as T).names[annotationClass] = value
//                }
//            }
//        }
//    }
//
//    /**
//     * [IRegistryKey]를 [Registries]에 등록합니다.
//     */
//    fun register() {
//        update()
//
//        // 이게 작동할까?
//        // todo: 디버깅하기
//        val properties = MyRegister::class.companionObject!!.declaredMemberProperties
//        for (property in properties) {
//            val register = (property.call(MyRegister) as? MyRegister<T>) ?: continue
//            register.forEach { it.register() }
//        }
//    }
//}