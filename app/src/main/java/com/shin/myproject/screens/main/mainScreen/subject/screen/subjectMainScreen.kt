package com.shin.myproject.screens.main.mainScreen.subject.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shin.myproject.navigation.routes.SubjectRoute
import com.shin.myproject.screens.main.mainScreen.subject.model.Subject
import com.shin.myproject.screens.main.mainScreen.subject.screen.subjectsscreen.embeddedSubjects
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectMainScreen(navController: NavController) {

    val allSubjects = Subject.subjectList + embeddedSubjects()
    val archive = SwipeAction(
        onSwipe = {
            Log.d("MainActivity", "Archive")
        },
        icon = {
            Icon(
                imageVector = Icons.Default.Archive,
                contentDescription = "archive" ,
                tint = Color.White
            )
        },
        background = Color.Black
    )
    val delete = SwipeAction(
        onSwipe = {
            Log.d("MainActivity", "Delete")
        },
        icon = {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "delete" ,
                tint = Color.White
            )
        },
        background = Color.Red
    )

    SwipeableActionsBox(startActions = listOf(archive)) {

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        LazyColumn {
            items(allSubjects) { subject ->
                ClickableSubjectCard(subject = subject) {

                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = {
                    navController.navigate(SubjectRoute.SubjectAddScreen.name)
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("Add New Subject")
            }
        }

    }
}
