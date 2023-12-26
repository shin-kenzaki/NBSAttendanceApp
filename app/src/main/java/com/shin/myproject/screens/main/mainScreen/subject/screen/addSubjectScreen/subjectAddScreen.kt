package com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.shin.myproject.ViewModel.AppViewModelProvider
import com.shin.myproject.ViewModel.subject.SubjectAddViewModel
import com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.component.Clock
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
    var subjectDay by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
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

            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                if (subjectCode.isEmpty()) {
                    Text("Subject code empty", color = Color.Red)
                    Modifier
                        .weight(1f)
                        .padding(5.dp)
                }
                if (subjectName.isEmpty()) {
                    Text("Subject name empty", color = Color.Red)
                    Modifier
                        .weight(3f)
                        .padding(5.dp)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val daysOfWeek = listOf(
                    "Mon" to "Monday",
                    "Tue" to "Tuesday",
                    "Wed" to "Wednesday",
                    "Thu" to "Thursday",
                    "Fri" to "Friday",
                    "Sat" to "Saturday"
                )
                daysOfWeek.forEach { (abbrev, fullName) ->
                    DaySelection(abbrev, subjectDay) {
                        subjectDay = it
                    }
                }
            }

            if (subjectDay.isEmpty()) {
                Text(
                    text = "Please select day",
                    color = Color.Red,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)  // Center the content inside the parent
                )
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
                                val formattedTime =
                                    String.format("%02d:%02d %s", hours, minutes, amPm.name)
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
                                val formattedTime =
                                    String.format("%02d:%02d %s", hours, minutes, amPm.name)
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        // TODO: Add action for Cancel button
                    },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text("Cancel", color = Color.White)
                    Icon(
                        imageVector = Icons.Default.Cancel,
                        contentDescription = "cancel button",
                        tint = Color.White
                    )
                }

                Button(
                    onClick = {
                        coroutineScope.launch {
                            // Check Subject Code, Name, and Selected Day before saving
                            if (subjectCode.isNotEmpty() && subjectName.isNotEmpty() && subjectDay.isNotEmpty()) {
                                // Save subject information using ViewModel
                                subjectAddViewModel.saveSubject(
                                    subjectCode = subjectCode,
                                    subjectName = subjectName,
                                    subjectDay = subjectDay,
                                    startTime = selectedStartTime,
                                    endTime = selectedEndTime,
                                    subjectDescription = subjectDescription
                                )

                                // TODO: Navigate back or perform any other action after saving
                            }
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text("Save", color = Color.White)
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "save button",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun DaySelection(abbrev: String, selectedDay: String, onDayClick: (String) -> Unit) {
    val isClicked = abbrev == selectedDay
    val circleColor = if (isClicked) Color.Red else Color.Gray

    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(circleColor)
            .clickable {
                onDayClick(abbrev)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = abbrev,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}