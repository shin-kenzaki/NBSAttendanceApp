package com.shin.myproject.user.repository.student


import com.shin.myproject.data.mainscreenModel.studentModel.Student
import kotlinx.coroutines.flow.Flow

interface StudentRepository {
    /**
     * Retrieve all the students from the given data source.
     */
    fun getAllStudentStream(): Flow<List<Student>>

    /**
     * Retrieve a student from the given data source that matches with the [studentId].
     */
    fun getStudentStream(studentId: Long): Flow<Student?>

    /**
     * Insert a student into the data source.
     */
    suspend fun insertStudent(student: Student)

    /**
     * Delete a student from the data source.
     */
    suspend fun deleteStudent(student: Student)

    /**
     * Update a student in the data source.
     */
    suspend fun updateStudent(student: Student)
}