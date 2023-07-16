package com.rhseung.abstractlib.api.annotation

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.EXPRESSION, AnnotationTarget.PROPERTY, AnnotationTarget.LOCAL_VARIABLE)
annotation class ko_kr(val value: String)
