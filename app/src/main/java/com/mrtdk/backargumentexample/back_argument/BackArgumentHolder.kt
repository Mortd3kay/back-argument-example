package com.mrtdk.backargumentexample.back_argument

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class BackArgumentHolder(internal val savedStateHandle: SavedStateHandle)

data class BackArgument<T>(
    val key: String,
    val defaultValue: T,
    val value: T? = null,
) : ReadWriteProperty<BackArgumentHolder, T> {
    override operator fun getValue(thisRef: BackArgumentHolder, property: KProperty<*>): T {
        return thisRef.savedStateHandle.get<T>(key) ?: defaultValue
    }

    override operator fun setValue(thisRef: BackArgumentHolder, property: KProperty<*>, value: T) {
        thisRef.savedStateHandle[key] = value
    }
}

fun<T> createBackArgument(key: String, defaultValue: T): (T?) -> BackArgument<T> {
    return { value ->
        BackArgument(
            key = key,
            defaultValue = defaultValue,
            value = value,
        )
    }
}

infix fun NavController.with(argument: BackArgument<*>): NavController = apply {
    previousBackStackEntry?.savedStateHandle?.set(argument.key, argument.value)
}