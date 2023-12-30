package com.shin.myproject.screens.main.mainScreen.subject.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.shin.myproject.ViewModel.AppViewModelProvider
import com.shin.myproject.ViewModel.student.StudentListViewModel
import com.shin.myproject.screens.main.mainScreen.subject.screen.addStudentScreen.component.StudentCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentScreen(
    navController: NavController,
    studentListViewModel: StudentListViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    LazyColumn {
        // Retrieve the list of students for the selected subject
        val students = studentListViewModel.studentsForSelectedSubject.value.orEmpty()

        // Display each student using the updated StudentCard
        items(students) { student ->
            StudentCard(student = student)
        }

        // If the student list is empty, display a message
        if (students.isEmpty()) {
            item {
                EmptyStudentListMessage()
            }
        }
    }
}

@Composable
fun EmptyStudentListMessage() {
    // You can customize the styling of the message as needed
    Text(
        text = "Add a student",
        color = Color.Red,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        textAlign = TextAlign.Center
    )
}