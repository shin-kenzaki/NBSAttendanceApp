package com.shin.myproject.screens.main.mainScreen.subject.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.shin.myproject.ViewModel.AppViewModelProvider
import com.shin.myproject.ViewModel.subject.SubjectListViewModel
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
        items(subjects) { subject ->
            SubjectCard(
                subject = subject,
                onClick = {
                    // Handle subject item click
                }
            )
        }
    }
}