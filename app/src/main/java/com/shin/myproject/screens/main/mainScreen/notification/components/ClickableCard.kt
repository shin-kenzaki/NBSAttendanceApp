package com.shin.myproject.screens.main.mainScreen.notification.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shin.myproject.R
import com.shin.myproject.screens.main.mainScreen.notification.model.Notification
import com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.model.DayListItem
import com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.model.SubjectData

@Composable
fun ClickableCard(notification: Notification, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = notification.subjectName
//                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = notification.notificationMessage
//                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Time: ${notification.time}"
//                style = MaterialTheme.typography.body2
            )
            Text(
                text = "Date: ${notification.date}"
//                style = MaterialTheme.typography.body2
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Navigate forward"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClickableCardPreview() {
    val sampleNotification = Notification(
        subjectCode = "CSC 331",
        subjectName = "CS Elective I (Track-based)",
        notificationMessage = "Upcoming class: Machine Learning",
        time = "11:00 AM - 2:00 PM",
        date = "Monday",
        notificationTime = "2023-12-01 15:30:00" // Replace with the actual timestamp
    )
    ClickableCard(notification = sampleNotification) {}
}