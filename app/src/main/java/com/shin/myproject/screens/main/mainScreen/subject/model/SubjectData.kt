package com.shin.myproject.screens.main.mainScreen.subject.model


data class SubjectData(
    val subjectCode: String,
    val subjectName: String,
    val selectedDays: List<DayListItem>,
    val startTime: String,
    val endTime: String
)