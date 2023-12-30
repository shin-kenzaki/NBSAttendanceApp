package com.shin.myproject.screens.main.mainScreen.subject.screen.addStudentScreen.component

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import com.shin.myproject.data.mainscreenModel.studentModel.Student
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox
import androidx.compose.ui.graphics.Color as ComposeColor

@Composable
fun StudentCard(student: Student) {
    val present = SwipeAction(
        onSwipe = {
            Log.d("Student", "Present")
        },
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                imageVector = Icons.Default.Check,
                contentDescription = "mark present",
                tint = ComposeColor.White
            )
        },
        background = Color.Green // Use a green color for the present action
    )
    val absent = SwipeAction(
        onSwipe = {
            Log.d("Student", "Absent")
        },
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                imageVector = Icons.Default.Clear,
                contentDescription = "mark absent",
                tint = ComposeColor.White
            )
        },
        background = Color.Red
    )

    SwipeableActionsBox(startActions = listOf(present), endActions = listOf(absent)) {
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
