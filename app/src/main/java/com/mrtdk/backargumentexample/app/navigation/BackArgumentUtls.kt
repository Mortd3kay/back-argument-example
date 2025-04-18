package com.mrtdk.backargumentexample.app.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import com.mrtdk.backargumentexample.back_argument.BackArgument
import com.mrtdk.backargumentexample.back_argument.BackArgumentHolder


//Here your project specific implementations

class SavedStateBackArgumentHolder(private val savedStateHandle: SavedStateHandle) :
    BackArgumentHolder {
    override fun <T> get(key: String): T? {
        return savedStateHandle.get<T>(key)
    }

    override fun <T> set(key: String, value: T) {
        savedStateHandle[key] = value
    }
}

infix fun <T : BackArgument<*>> NavController.with(argument: T): NavController = apply {
    previousBackStackEntry?.savedStateHandle?.set(argument.key, argument.value)
}