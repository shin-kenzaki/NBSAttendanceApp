package com.shin.myproject.screens.main.mainScreen.subject.screen.addsubjectscreen

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
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.shin.myproject.navigation.routes.SubjectRoute
import com.shin.myproject.screens.main.mainScreen.subject.model.DayListItem
import com.shin.myproject.screens.main.mainScreen.subject.model.Subject
import com.shin.myproject.screens.main.mainScreen.subject.model.SubjectData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectAddScreen(navController: NavController) {
    var subjectCode by remember { mutableStateOf("") }
    var subjectName by remember { mutableStateOf("") }
    var subjectDescription by remember { mutableStateOf("") }
    var selectedStartTime by remember { mutableStateOf("00:00 AM") }
    var selectedEndTime by remember { mutableStateOf("00:00 AM") }
    var selectedDays by remember { mutableStateOf(emptyList<DayListItem>()) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Add Subject Screen")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
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

            DaySelect { days ->
                selectedDays = days
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Clock(
                    title = "Start Time",
                    onTimeSelected = { hours, minutes, amPm ->
                        val formattedTime = String.format("%02d:%02d %s", hours, minutes, amPm.name)
                        selectedStartTime = formattedTime
                    }
                )
                OutlinedTextField(
                    value = selectedStartTime,
                    onValueChange = { /* Nothing for now */ },
                    label = { Text("Selected Start Time") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(5.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Clock(
                    title = "End Time",
                    onTimeSelected = { hours, minutes, amPm ->
                        val formattedTime = String.format("%02d:%02d %s", hours, minutes, amPm.name)
                        selectedEndTime = formattedTime
                    }
                )

                OutlinedTextField(
                    value = selectedEndTime,
                    onValueChange = { /* Nothing for now */ },
                    label = { Text("Selected End Time") },
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
                    if (subjectCode.isNotEmpty() && subjectName.isNotEmpty()) {
                        val subjectData = SubjectData(
                            subjectCode = subjectCode,
                            subjectName = subjectName,
                            subjectDescription = subjectDescription,
                            selectedDays = selectedDays,
                            startTime = selectedStartTime,
                            endTime = selectedEndTime
                        )
                        Subject.subjectList.add(subjectData)
                        navController.navigate(route = SubjectRoute.SubjectMainScreen.name)
                    } else {
                        errorMessage = "Subject code and subject name cannot be empty"
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
}

@Composable
@Preview(showBackground = true)
fun SubjectAddScreenPreview() {
    val navController = rememberNavController()
    SubjectAddScreen(navController = navController)
}

