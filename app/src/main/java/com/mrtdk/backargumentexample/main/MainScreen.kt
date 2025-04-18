package com.mrtdk.backargumentexample.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mrtdk.backargumentexample.app.navigation.SavedStateBackArgumentHolder
import com.mrtdk.backargumentexample.dialog.api.commentDialogRoute

@Composable
fun MainScreen(
    savedStateHandle: SavedStateHandle,
    navController: NavController,
) {
    val vm = viewModel<MainViewModel>(
        factory = MainViewModelFactory(SavedStateBackArgumentHolder(savedStateHandle))
    )
    
    DisposableEffect(navController) {
        vm.router = Router { navController.navigate(commentDialogRoute) }
        onDispose { vm.router = null }
    }

    val comments by vm.commentsFlow.collectAsStateWithLifecycle(emptyList())

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {

            LazyColumn {
                items(comments) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 16.dp),
                        text = it,
                    )
                    HorizontalDivider()
                }
            }

            Button(
                onClick = vm::addComment
            ) {
                Text(text = "Add Comment")
            }
        }
    }
} 