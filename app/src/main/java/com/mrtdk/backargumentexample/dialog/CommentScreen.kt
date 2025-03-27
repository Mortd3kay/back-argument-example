package com.mrtdk.backargumentexample.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mrtdk.backargumentexample.back_argument.with
import com.mrtdk.backargumentexample.dialog.api.commentResult

@Composable
fun CommentScreen(
    navController: NavController,
) {
    val vm = viewModel<CommentViewModel>()
    DisposableEffect(navController) {
        vm.router = Router { navController.with(commentResult(it)).popBackStack() }
        onDispose { vm.router = null }
    }
    val comment by vm.commentFlow.collectAsStateWithLifecycle()
    
    Column(
        modifier = Modifier
            .background(color = Color.DarkGray)
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        OutlinedTextField(
            value = comment,
            onValueChange = vm::onChangeComment,
            label = { Text("Enter comment") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = vm::saveComment,
            enabled = comment.isNotBlank()
        ) {
            Text("Submit")
        }
    }
} 