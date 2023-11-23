package com.shin.myproject.screens.main.mainScreen.subject.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shin.myproject.navigation.routes.SubjectRoute
import com.shin.myproject.screens.main.mainScreen.subject.model.Subject
import com.shin.myproject.screens.main.mainScreen.subject.screen.addsubjectscreen.embeddedSubjects

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectMainScreen(navController: NavController) {

    val allSubjects = Subject.subjectList + embeddedSubjects()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Subjects") },
                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate(SubjectRoute.SubjectAddScreen.name)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "add new subject"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


//        LazyColumn {
//            items(allSubjects) { subject ->
//                ClickableSubjectCard(subject = subject) {
//                }
//            }
//        }

            LazyColumn {
                items(allSubjects) { subject ->
                    SwipeableCard(subject = subject) {
                    }
                }
            }
        }
    }
}
