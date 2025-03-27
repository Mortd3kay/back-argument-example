package com.mrtdk.backargumentexample.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mrtdk.backargumentexample.back_argument.BackArgumentHolder

class MainViewModelFactory(
    private val backArgumentHolder: BackArgumentHolder
) : ViewModelProvider.Factory {
    
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(backArgumentHolder) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
} 