package com.shin.myproject.screens.main.mainScreen.subject.screen.addStudentScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardBackspace
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shin.myproject.navigation.routes.MainRoute
import com.shin.myproject.screens.main.mainScreen.subject.screen.addStudentScreen.model.StudentData
import com.shin.myproject.screens.main.mainScreen.subject.screen.addStudentScreen.model.StudentList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentAddScreen(navController : NavController) {
    var id by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var middleInit by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var isWorking by remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Student") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(route = MainRoute.Subjects.name)}) {
                        Icon(
                            imageVector = Icons.Default.KeyboardBackspace,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            OutlinedTextField(
                value = id,
                onValueChange = { id = it },
                label = { Text("ID") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                OutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    label = { Text("First Name") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )
                OutlinedTextField(
                    value = middleInit,
                    onValueChange = { middleInit = it },
                    label = { Text("Middle Initial") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    label = { Text("Last Name") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Text("Working Student")
                Spacer(modifier = Modifier.width(8.dp))
                Checkbox(
                    checked = isWorking,
                    onCheckedChange = { isWorking = it },
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            Button(
                onClick = {
                    // Save button action
                    val studentToAdd = StudentData(id, firstName, middleInit, lastName)
                    StudentList.students.add(studentToAdd)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .background(color = Color.Red)
            ) {
                Text("Save")
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}