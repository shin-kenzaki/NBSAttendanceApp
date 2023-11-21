package com.shin.myproject.screens.main.mainScreen.subject.screen.subjectsscreen

import com.shin.myproject.screens.main.mainScreen.subject.model.DayListItem
import com.shin.myproject.screens.main.mainScreen.subject.model.SubjectData

// Function to generate sample subjects
fun embeddedSubjects(): List<SubjectData> {
    return listOf(
        SubjectData(
            subjectCode = "CS101",
            subjectName = "Introduction to Computer Science",
            selectedDays = listOf(DayListItem("M", true), DayListItem("W", true), DayListItem("F", true)),
            startTime = "09:00 AM",
            endTime = "10:30 AM"
        ),
        SubjectData(
            subjectCode = "MATH201",
            subjectName = "Calculus",
            selectedDays = listOf(DayListItem("T", true), DayListItem("R", true)),
            startTime = "11:00 AM",
            endTime = "12:30 PM"
        ),
        SubjectData(
            subjectCode = "ENG101",
            subjectName = "English Composition",
            selectedDays = listOf(DayListItem("M", true), DayListItem("W", true), DayListItem("F", true)),
            startTime = "01:00 PM",
            endTime = "02:30 PM"
        ),
        SubjectData(
            subjectCode = "PHYS202",
            subjectName = "Physics II",
            selectedDays = listOf(DayListItem("T", true), DayListItem("R", true)),
            startTime = "03:00 PM",
            endTime = "04:30 PM"
        ),
        SubjectData(
            subjectCode = "ART105",
            subjectName = "Introduction to Art",
            selectedDays = listOf(DayListItem("M", true), DayListItem("W", true), DayListItem("F", true)),
            startTime = "05:00 PM",
            endTime = "06:30 PM"
        )
    )
}
