package com.shin.myproject.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shin.myproject.ViewModel.ScreenViewModel
import com.shin.myproject.navigation.routes.SubjectRoute
import com.shin.myproject.screens.main.mainScreen.subject.screen.addsubjectscreen.SubjectAddScreen
import com.shin.myproject.screens.main.mainScreen.subject.screen.subjectsscreen.CSC322
import com.shin.myproject.screens.main.mainScreen.subject.screen.subjectsscreen.CSC323
import com.shin.myproject.screens.main.mainScreen.subject.screen.subjectsscreen.CSC324


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectScreen(
    navController: NavHostController,
    screenViewModel: ScreenViewModel,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Your Title Here") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) {innerPadding ->
        Modifier.padding(innerPadding)

        val navController: NavHostController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = SubjectRoute.SubjectMainScreen.name
        ) {
            composable(route = SubjectRoute.SubjectMainScreen.name) {
                SubjectAddScreen(navController)
            }
            composable(route = SubjectRoute.SubjectAddScreen.name) {
                SubjectAddScreen(navController)
            }
            composable(route = SubjectRoute.CSC322.name) {
                CSC322(navController)
            }
            composable(route = SubjectRoute.CSC323.name) {
                CSC323(navController)
            }
            composable(route = SubjectRoute.CSC324.name) {
                CSC324(navController)
            }
        }
    }
}