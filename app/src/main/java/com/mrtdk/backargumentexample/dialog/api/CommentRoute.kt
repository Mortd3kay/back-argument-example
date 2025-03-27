package com.mrtdk.backargumentexample.dialog.api

import com.mrtdk.backargumentexample.back_argument.BackArgumentHolder
import com.mrtdk.backargumentexample.back_argument.createBackArgument

// Screen opening contract
val commentDialogRoute = "comment_dialog_route"

// Result contract
internal val commentResult = createBackArgument("comment_from_dialog", "")

var BackArgumentHolder.comment: String by commentResult(null)