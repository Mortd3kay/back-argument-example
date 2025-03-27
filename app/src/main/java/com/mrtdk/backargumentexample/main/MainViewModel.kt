package com.mrtdk.backargumentexample.main

import androidx.lifecycle.ViewModel
import com.mrtdk.backargumentexample.back_argument.BackArgumentHolder
import com.mrtdk.backargumentexample.dialog.api.comment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

fun interface Router {
    fun openCommentDialog()
}

class MainViewModel(
    private val backArgumentHolder: BackArgumentHolder,
) : ViewModel() {
    var router: Router? = null

    private val _commentsFlow = MutableStateFlow(listOf<String>())
    val commentsFlow = _commentsFlow.asStateFlow()
        .onStart {
            backArgumentHolder.comment
                .takeIf { it.isNotEmpty() }
                ?.let { comment -> _commentsFlow.update { it + comment } }
            backArgumentHolder.comment = ""
        }

    fun addComment() {
        router?.openCommentDialog()
    }
} 