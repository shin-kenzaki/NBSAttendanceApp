package com.shin.myproject.screens.main.mainScreen.notification.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.shin.myproject.screens.main.mainScreen.embeddedSubjects
import com.shin.myproject.screens.main.mainScreen.notification.components.ClickableCard
import com.shin.myproject.screens.main.mainScreen.notification.model.Notification
import com.shin.myproject.screens.main.mainScreen.notification.model.NotificationProvider

@Composable
fun NotificationScreen(navController: NavController, subjects: List<Notification>) {
    val embeddedSubjects = embeddedSubjects()
    val notifications = NotificationProvider.getNotificationsForSubjects(embeddedSubjects)

    LazyColumn {
        items(notifications) { notification ->
            ClickableCard(notification = notification) {
                // Handle click action, for example, navigate to a detail screen
                // or perform an action related to the notification.
            }
        }
    }
}