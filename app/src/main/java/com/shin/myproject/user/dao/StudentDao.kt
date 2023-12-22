package com.shin.myproject.user.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.shin.myproject.data.mainscreenModel.studentModel.Student


@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(student: Student)

    @Update
    suspend fun update(student: Student)

    @Delete
    suspend fun delete(student: Student)

//    @Query("DELETE FROM Students WHERE subject_id = :subjectId")
//    fun deleteStudentsBySubjectId(subjectId: Long)
}