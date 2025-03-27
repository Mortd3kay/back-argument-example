package com.mrtdk.backargumentexample.dialog

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

fun interface Router {
    fun goBack(comment: String)
}

class CommentViewModel : ViewModel() {
    var router: Router? = null

    private val _commentFlow = MutableStateFlow("")
    val commentFlow = _commentFlow.asStateFlow()

    fun onChangeComment(newComment: String) {
        _commentFlow.tryEmit(newComment)
    }

    fun saveComment() {
        router?.goBack(_commentFlow.value)
    }
} 