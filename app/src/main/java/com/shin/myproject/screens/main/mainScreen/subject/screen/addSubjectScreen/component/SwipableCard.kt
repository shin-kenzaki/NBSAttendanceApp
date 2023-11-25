package com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.component

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.model.SubjectData
import com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.model.SubjectLogos
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@Composable
fun subjectCard(subject: SubjectData, onClick: () -> Unit, onCardClick: () -> Unit) {

    val logo = SubjectLogos.getLogoForSubject(subject.subjectName)
    val archive = SwipeAction(
        onSwipe = {
            Log.d("MainActivity", "Archive")
        },
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                imageVector = Icons.Default.Archive,
                contentDescription = "archive" ,
                tint = Color.White
            )
        },
        background = Color.LightGray
    )
    val delete = SwipeAction(
        onSwipe = {
            Log.d("MainActivity", "Delete")
        },
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                imageVector = Icons.Default.Delete,
                contentDescription = "delete" ,
                tint = Color.White
            )
        },
        background = Color.Red

    )

    SwipeableActionsBox(startActions = listOf(archive), endActions = listOf(delete)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .clickable {
                    onClick()
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { onClick() }
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        modifier = Modifier
                            .size(60.dp)
                            .padding(horizontal = 10.dp),
                        imageVector = logo,
                        contentDescription = "logo"
                    )
                }

                Column(
                    modifier = Modifier.weight(3f),
                ) {
                    Text(text = "${subject.subjectCode} - ${subject.subjectName}")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "${subject.selectedDays.joinToString(" , ") { it.title }}")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "${subject.startTime} - ${subject.endTime}")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "${subject.subjectDescription}")
                }
            }
        }
    }
}