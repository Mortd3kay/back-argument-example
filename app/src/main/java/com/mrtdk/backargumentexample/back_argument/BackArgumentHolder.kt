package com.mrtdk.backargumentexample.back_argument

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

interface BackArgumentHolder {
    operator fun <T> get(key: String): T?
    operator fun <T> set(key: String, value: T)
}

data class BackArgument<T>(
    val key: String,
    val defaultValue: T,
    val value: T? = null,
) : ReadWriteProperty<BackArgumentHolder, T> {
    override operator fun getValue(thisRef: BackArgumentHolder, property: KProperty<*>): T {
        return thisRef[key] ?: defaultValue
    }

    override operator fun setValue(thisRef: BackArgumentHolder, property: KProperty<*>, value: T) {
        thisRef[key] = value
    }
}

fun <T> createBackArgument(key: String, defaultValue: T): (T?) -> BackArgument<T> {
    return { value ->
        BackArgument(
            key = key,
            defaultValue = defaultValue,
            value = value,
        )
    }
}