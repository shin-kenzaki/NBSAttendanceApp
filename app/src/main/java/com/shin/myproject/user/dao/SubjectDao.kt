package com.shin.myproject.user.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.shin.myproject.data.mainscreenModel.subjectModel.Subject

@Dao
interface SubjectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(subject: Subject)

    @Update
    suspend fun update(subject: Subject)

    @Delete
    suspend fun delete(subject: Subject)

//    @Query("DELETE FROM Subjects WHERE user_id = :userId")
//    fun deleteSubjectsByUserId(userId: Int)
}