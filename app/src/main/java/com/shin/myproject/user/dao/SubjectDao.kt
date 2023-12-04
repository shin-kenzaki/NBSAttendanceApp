package com.shin.myproject.user.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.shin.myproject.data.mainscreenModel.subjectModel.Subject
import kotlinx.coroutines.flow.Flow

@Dao
interface SubjectDao {

    @Query("SELECT * from Subjects ORDER BY subject_id ASC")
    fun getAllSubject(): Flow<List<Subject>>

    @Query("SELECT * from Subjects WHERE subject_id = :id")
    fun getSubject(id: Long): Flow<Subject>

    // Specify the conflict strategy as REPLACE, when the user tries to add an
    // existing User into the database Room REPLACES the conflict.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(subject: Subject)

    @Update
    suspend fun update(subject: Subject)

    @Delete
    suspend fun delete(subject: Subject)
}