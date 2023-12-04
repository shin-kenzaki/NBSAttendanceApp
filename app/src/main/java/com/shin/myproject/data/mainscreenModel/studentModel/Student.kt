package com.shin.myproject.data.mainscreenModel.studentModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Students")
data class Student(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    val studentId: Long = 0,
    @ColumnInfo(name = "subject_id")
    val subjectId: Long,
    val studentNumber: String,
    val firstname: String,
    val lastname: String,
    val course: String,
    val year: Int,
    @ColumnInfo(name = "is_working_student")
    val isWorkingStudent: Boolean
)