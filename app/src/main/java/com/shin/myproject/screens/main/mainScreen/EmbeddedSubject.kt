package com.shin.myproject.screens.main.mainScreen

import com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.model.DayListItem
import com.shin.myproject.screens.main.mainScreen.subject.screen.addSubjectScreen.model.SubjectData

fun embeddedSubjects(): List<SubjectData> {
    return listOf(
        SubjectData(
            subjectCode = "CSC 331",
            subjectName = "CS Elective I (Track-based)",
            selectedDays = listOf(DayListItem("Monday", true)),
            startTime = "11:00 AM",
            endTime = "2:00 PM",
            subjectDescription = "Machine Learning"
        ),
        SubjectData(
            subjectCode = "CSC 325",
            subjectName = "Operating Systems",
            selectedDays = listOf(DayListItem("Tuesday", true), DayListItem("Thursday", true)),
            startTime = "7:30 AM",
            endTime = "10:30 AM",
            subjectDescription = "Computer's Operating Systems"
        ),
        SubjectData(
            subjectCode = "CSC 311",
            subjectName = "Application Development and Emerging Technology",
            selectedDays = listOf(DayListItem("Tuesday", true), DayListItem("Thursday", true)),
            startTime = "11:30 AM",
            endTime = "2:30 PM",
            subjectDescription = "SDLC"
        ),
        SubjectData(
            subjectCode = "CSC 324",
            subjectName = "Structures of Programming Languages",
            selectedDays = listOf(DayListItem("Tuesday", true), DayListItem("Thursday", true)),
            startTime = "3:00 PM",
            endTime = "6:00 PM",
            subjectDescription = "Understanding Different Programming Languages"
        ),
        SubjectData(
            subjectCode = "GED 205",
            subjectName = "Contextualized Communication in Filipino",
            selectedDays = listOf(DayListItem("Thursday", true)),
            startTime = "5:00 PM",
            endTime = "8:00 PM",
            subjectDescription = "Filipino Literatures and Communication"
        ),
        SubjectData(
            subjectCode = "CSC 322",
            subjectName = "Automata Theory and Formal Languages",
            selectedDays = listOf(DayListItem("Friday", true)),
            startTime = "7:30 AM",
            endTime = "12:30 PM",
            subjectDescription = "Arduino Circuits and Assembly Language"
        ),
        SubjectData(
            subjectCode = "THS 321",
            subjectName = "Thesis Writing 1",
            selectedDays = listOf(DayListItem("Friday", true)),
            startTime = "2:00 PM",
            endTime = "5:00 PM",
            subjectDescription = "Thesis Writing"
        ),
        SubjectData(
            subjectCode = "CSC 321",
            subjectName = "Fundamentals of Human Computer Interaction",
            selectedDays = listOf(DayListItem("Friday", true)),
            startTime = "5:30 PM",
            endTime = "7:30 PM",
            subjectDescription = "Human and Computer Interactions"
        ),
        SubjectData(
            subjectCode = "CSC 323",
            subjectName = "Mobile Device Application Principles",
            selectedDays = listOf(DayListItem("Saturday", true)),
            startTime = "12:00 PM",
            endTime = "5:30 PM",
            subjectDescription = "Mobile App Developing"
        )
    )
}