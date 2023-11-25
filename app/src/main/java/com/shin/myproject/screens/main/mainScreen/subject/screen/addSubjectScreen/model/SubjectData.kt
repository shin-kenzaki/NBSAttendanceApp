package com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.model

import com.shin.myproject.screens.main.mainScreen.subject.screen.addStudentScreen.model.StudentData

data class SubjectData(
    val subjectCode: String,
    val subjectName: String,
    val subjectDescription: String,
    val selectedDays: List<DayListItem>,
    val startTime: String,
    val endTime: String,
    val enrolledStudents: List<StudentData> = mutableListOf()
)