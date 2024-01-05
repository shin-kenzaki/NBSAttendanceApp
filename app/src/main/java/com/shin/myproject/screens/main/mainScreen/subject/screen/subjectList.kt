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
import com.shin.myproject.ViewModel.subject.SubjectListViewModel
import com.shin.myproject.navigation.routes.SubjectRoute
import com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.component.SubjectCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectScreen(
    navController: NavController,
    subjectListViewModel: SubjectListViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    // Load subjects when the screen is created
    subjectListViewModel.loadSubjects()

    // Observe the subjectList LiveData
    val subjects = subjectListViewModel.subjectList.value ?: emptyList()

    LazyColumn {
        // If the subject list is empty, display a message
        if (subjects.isEmpty()) {
            item {
                EmptySubjectListMessage()
            }
        } else {
            // Display each subject using the SubjectCard
            items(subjects) { subject ->
                SubjectCard(
                    subject = subject,
                    onClick = {
                        // Call the onSubjectClicked function when the card is clicked
                        subjectListViewModel.onSubjectClicked(subject.subjectId)
                        navController.navigate(SubjectRoute.StudentsScreen.name)
                    }
                )
            }
        }
    }
}

@Composable
fun EmptySubjectListMessage() {
    Text(
        text = "Add a subject",
        color = Color.Red,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        textAlign = TextAlign.Center
    )
}