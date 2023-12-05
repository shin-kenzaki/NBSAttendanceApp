package com.shin.myproject.user.repository.subject


import com.shin.myproject.data.mainscreenModel.studentModel.Student
import com.shin.myproject.data.mainscreenModel.subjectModel.Subject
import kotlinx.coroutines.flow.Flow

interface SubjectRepository {

    /**
     * Insert a student into the data source.
     */
    suspend fun insertSubject(subject: Subject)

    /**
     * Delete a student from the data source.
     */
    suspend fun deleteSubject(subject: Subject)

    /**
     * Update a student in the data source.
     */
    suspend fun updateSubject(subject: Subject)
}