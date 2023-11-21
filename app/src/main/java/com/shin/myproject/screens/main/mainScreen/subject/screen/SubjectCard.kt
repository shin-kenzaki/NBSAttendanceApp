package com.shin.myproject.screens.main.mainScreen.subject.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shin.myproject.screens.main.mainScreen.subject.model.SubjectData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClickableSubjectCard(subject: SubjectData, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Subject Code: ${subject.subjectCode}")
            Text(text = "Subject Name: ${subject.subjectName}")
            Text(text = "Days: ${subject.selectedDays.joinToString(", ") { it.title }}")
            Text(text = "Start Time: ${subject.startTime}")
            Text(text = "End Time: ${subject.endTime}")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ClickableSubjectCardPreview() {
    // Preview content here
}