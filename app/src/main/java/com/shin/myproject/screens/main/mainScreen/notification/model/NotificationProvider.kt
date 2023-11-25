package com.shin.myproject.screens.main.mainScreen.notification.model

import com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.model.SubjectData
import java.text.SimpleDateFormat
import java.util.Locale

object NotificationProvider {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

    fun getNotificationsForSubjects(subjects: List<SubjectData>): List<Notification> {
        val notifications = mutableListOf<Notification>()

        for (subject in subjects) {
            // Customize the notification message based on your requirements
            val notificationMessage = "Upcoming class: ${subject.subjectName}"

            // Generate the current timestamp for notificationTime
            val currentTimestamp = System.currentTimeMillis()
            val notificationTime = dateFormat.format(currentTimestamp)

            // Add the time, date, and notificationTime information
            val notification = Notification(
                subjectCode = subject.subjectCode,
                subjectName = subject.subjectName,
                notificationMessage = notificationMessage,
                time = "${subject.startTime} - ${subject.endTime}",
                date = subject.selectedDays.joinToString(", ") { it.title },
                notificationTime = notificationTime
            )

            notifications.add(notification)
        }

        return notifications
    }
}