package com.shin.myproject.ViewModel.student

import androidx.lifecycle.ViewModel
import com.shin.myproject.data.mainscreenModel.studentModel.Student
import com.shin.myproject.data.mainscreenModel.studentModel.StudentList

class StudentAddViewModel : ViewModel() {

    fun addStudent(id: String, firstName: String, middleInit: String, lastName: String, isWorking: Boolean) {
        // Create a Student instance with the provided values
        val studentToAdd = Student(
            subjectId = 0, // Assuming you want to set subjectId to 0 for now
            studentNumber = id,
            firstname = firstName,
            lastname = lastName,
            course = "", // You might want to set this to an appropriate value
            year = 0, // You might want to set this to an appropriate value
            isWorkingStudent = isWorking
        )

        // Add the student to the list or save it to a database
        StudentList.students.add(studentToAdd)
    }
}
