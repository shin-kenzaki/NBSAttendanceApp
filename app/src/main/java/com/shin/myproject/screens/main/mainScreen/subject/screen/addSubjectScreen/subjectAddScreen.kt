package com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.shin.myproject.ViewModel.subject.SubjectAddViewModel
import com.shin.myproject.ViewModel.subject.SubjectDetails
import com.shin.myproject.ViewModel.AppViewModelProvider
import com.shin.myproject.data.mainscreenModel.subjectModel.DayListItem
import com.shin.myproject.navigation.routes.AuthRoute
import com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.component.Clock
import com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.component.daySelect
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectAddScreen(
    navController: NavController,
    subjectAddViewModel: SubjectAddViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    var subjectCode by remember { mutableStateOf("") }
    var subjectName by remember { mutableStateOf("") }
    var subjectDescription by remember { mutableStateOf("") }
    var selectedStartTime by remember { mutableStateOf("00:00 AM") }
    var selectedEndTime by remember { mutableStateOf("00:00 AM") }
    var selectedDays by remember { mutableStateOf(emptyList<DayListItem>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedTextField(
                value = subjectCode,
                onValueChange = { subjectCode = it },
                label = { Text("Subject Code") },
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp),
                singleLine = true
            )

            OutlinedTextField(
                value = subjectName,
                onValueChange = { subjectName = it },
                label = { Text("Subject Name") },
                modifier = Modifier
                    .weight(3f)
                    .padding(5.dp),
                singleLine = true
            )
        }

        daySelect { days ->
            selectedDays = days
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = selectedStartTime,
                onValueChange = { /* Nothing for now */ },
                label = { Text("Selected Start Time") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray
                ),
                trailingIcon = {
                    Clock(
                        contentDescription = "Start Time",
                        onTimeSelected = { hours, minutes, amPm ->
                            val formattedTime = String.format("%02d:%02d %s", hours, minutes, amPm.name)
                            selectedStartTime = formattedTime
                        }
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(5.dp)
            )

            OutlinedTextField(
                value = selectedEndTime,
                onValueChange = { /* Nothing for now */ },
                label = { Text("End Time") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Gray
                ),
                trailingIcon = {
                    Clock(
                        contentDescription = "End Time",
                        onTimeSelected = { hours, minutes, amPm ->
                            val formattedTime = String.format("%02d:%02d %s", hours, minutes, amPm.name)
                            selectedEndTime = formattedTime
                        }
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(5.dp)
            )
        }

        OutlinedTextField(
            value = subjectDescription,
            onValueChange = { subjectDescription = it },
            label = { Text("Subject Description") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
        Button(
            onClick = {
                coroutineScope.launch {
                    var subjectUiState = subjectAddViewModel.subjectUiState
                    subjectUiState.subjectDetails = SubjectDetails(
                        subjectCode = subjectCode,
                        subjectName = subjectName,
                        subjectDay = selectedDays,
                        startTime = selectedStartTime,
                        endTime = selectedEndTime,
                        subjectDescription = subjectDescription
                    )
                    subjectAddViewModel.saveSubject()
                    Log.i("subjectUiState", subjectUiState.subjectDetails.toString())
                    navController.navigate(AuthRoute.LoginScreen.name)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
        ) {
            Text("Save")
        }
    }
}