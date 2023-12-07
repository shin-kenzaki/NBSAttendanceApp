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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.shin.myproject.ViewModel.subject.SubjectScreenViewModel
import com.shin.myproject.data.mainscreenModel.subjectModel.SubjectList.subjects
import com.shin.myproject.navigation.routes.SubjectRoute
import com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.component.subjectCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectScreen(navController: NavController, viewModel: SubjectScreenViewModel = viewModel()) {

}