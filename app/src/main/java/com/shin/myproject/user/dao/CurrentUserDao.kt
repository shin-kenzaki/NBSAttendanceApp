package com.shin.myproject.user.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shin.myproject.data.authModel.CurrentUser

@Dao
interface CurrentUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrentUser(currentUser: CurrentUser)

    @Query("SELECT * FROM currentuser LIMIT 1")
    suspend fun getCurrentUser(): CurrentUser?

    @Query("DELETE FROM currentuser")
    suspend fun clearCurrentUser()
}