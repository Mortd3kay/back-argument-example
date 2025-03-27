package com.mrtdk.backargumentexample.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import com.mrtdk.backargumentexample.dialog.CommentScreen
import com.mrtdk.backargumentexample.dialog.api.commentDialogRoute
import com.mrtdk.backargumentexample.main.MainScreen
import com.mrtdk.backargumentexample.main.api.mainRoute


@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = mainRoute
    ) {
        composable(mainRoute) {
            MainScreen(
                savedStateHandle = it.savedStateHandle,
                navController = navController,
            )
        }

        composable(commentDialogRoute) {
            CommentScreen(
                navController = navController,
            )
        }
    }
} 