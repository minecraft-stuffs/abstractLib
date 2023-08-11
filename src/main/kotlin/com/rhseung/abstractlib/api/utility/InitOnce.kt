//package com.rhseung.abstractlib.api.utility
//
//import java.io.Serializable
//import kotlin.properties.ReadWriteProperty
//import kotlin.reflect.KProperty
//
//private object EMPTY
//
//class SyncronizedLazy<out T>(
//    initializer: () -> T,
//    lock: Any? = null
//) : Lazy<T>, Serializable {
//
//    private var initializer: (() -> T)? = initializer
//    private val lock = lock ?: this
//    private var _value: Any? = EMPTY
//
//    override val value: T
//        get() {
//            val _v1 = _value
//            if (_v1 !== EMPTY) {    // 참조(주소) 비교는 ===
//                @Suppress("UNCHECKED_CAST")
//                return _v1 as T
//            }
//
//            return synchronized(lock) {
//                val _v2 = _value
//                if (_v2 !== EMPTY) {
//                    @Suppress("UNCHECKED_CAST")
//                    _v2 as T
//                } else {
//                    val typedValue = initializer!!()
//                    _value = typedValue
//                    initializer = null
//                    typedValue
//                }
//            }
//        }
//
//    override fun isInitialized(): Boolean {
//        return _value !== EMPTY
//    }
//
//    override fun toString(): String {
//        return if (isInitialized()) {
//            value.toString()
//        } else {
//            "Lazy value가 아직 초기화되지 않았습니다."
//        }
//    }
//}
//
//class InitOnce<T> private constructor() : ReadWriteProperty<Any?, T> {
//    private var value: Any? = EMPTY
//
//    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
//        if (this.value == EMPTY) {
//            throw IllegalStateException("속성 '${property.name}' 는 초기화되지 않았습니다.")
//        } else {
//            @Suppress("UNCHECKED_CAST")
//            return this.value as T
//        }
//    }
//
//    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
//        if (this.value != EMPTY) {
//            throw IllegalStateException("속성 '${property.name}' 는 이미 초기화되었습니다.")
//        } else {
//            this.value = value
//        }
//    }
//
//    companion object {
//        fun <T> initOnce(): ReadWriteProperty<Any?, T> = InitOnce()
//        fun <T> lazy(initializer: () -> T) = SyncronizedLazy(initializer)
//    }
//}