package com.shin.myproject.screens.main.mainScreen.subject.screen.addStudentScreen.component

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.unit.dp
import com.shin.myproject.data.mainscreenModel.studentModel.Student
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@Composable
fun studentCard(student: Student, onDelete: () -> Unit) {
    val archive = SwipeAction(
        onSwipe = {
            Log.d("MainActivity", "Archive")
        },
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                imageVector = Icons.Default.Check,
                contentDescription = "archive",
                tint = ComposeColor.White
            )
        },
        background = Color.LightGray
    )
    val delete = SwipeAction(
        onSwipe = {
            onDelete()
        },
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                imageVector = Icons.Default.Clear,
                contentDescription = "delete",
                tint = ComposeColor.White
            )
        },
        background = Color.Red
    )

    SwipeableActionsBox(startActions = listOf(archive), endActions = listOf(delete)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Add any icon or avatar for the student here
                }

                Column(
                    modifier = Modifier.weight(3f),
                ) {
                    Text(text = "Student ID: ${student.studentId}")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Name: ${student.firstname} ${student.lastname}")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Course: ${student.course}")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Year: ${student.year}")
                }
            }
        }
    }
}
