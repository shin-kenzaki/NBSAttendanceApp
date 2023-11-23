package com.shin.myproject.screens.main.mainScreen.subject.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.shin.myproject.screens.main.mainScreen.subject.model.SubjectData


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectAttendanceScreen(navController: NavController, subjectData: SubjectData) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = subjectData.subjectName)
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            // Add content specific to the subject detail screen
            // You can display attendance details, student list, etc.
        }
    }
}