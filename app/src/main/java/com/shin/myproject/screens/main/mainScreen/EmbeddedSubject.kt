package com.shin.myproject.screens.main.mainScreen

import com.shin.myproject.data.mainscreenModel.subjectModel.DayListItem
import com.shin.myproject.data.mainscreenModel.subjectModel.Subject

fun embeddedSubjects(userId: Long): List<Subject> {
//    val userId = // your actual user ID
//    val subjects = embeddedSubjects(userId)
    return listOf(
        Subject(
            userId = userId,
            subjectCode = "CSC 331",
            subjectName = "CS Elective I (Track-based)",
            subjectDay = "Monday",
            startTime = "11:00 AM",
            endTime = "2:00 PM",
            subjectDescription = "Machine Learning"
        ),
        Subject(
            userId = userId,
            subjectCode = "CSC 325",
            subjectName = "Operating Systems",
            subjectDay = "Tuesday, Thursday",
            startTime = "7:30 AM",
            endTime = "10:30 AM",
            subjectDescription = "Computer's Operating Systems"
        ),
        // ... (Repeat for other subjects)
    )
}