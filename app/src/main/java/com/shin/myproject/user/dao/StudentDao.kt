package com.shin.myproject.user.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.shin.myproject.data.mainscreenModel.studentModel.Student
import kotlinx.coroutines.flow.Flow


@Dao
interface StudentDao {

    @Query("SELECT * from Students ORDER BY student_id ASC")
    fun getAllStudent(): Flow<List<Student>>

    @Query("SELECT * from Students WHERE student_id = :id")
    fun getStudent(id: Long): Flow<Student>

    // Specify the conflict strategy as REPLACE, when the user tries to add an
    // existing User into the database Room REPLACES the conflict.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(student: Student)

    @Update
    suspend fun update(student: Student)

    @Delete
    suspend fun delete(student: Student)
}