package com.shin.myproject.user.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.shin.myproject.data.authModel.User
import kotlinx.coroutines.flow.Flow

/**
 * Database access object to access the NBS database
 */
@Dao
interface UserDao {

    @Query("SELECT * from Users ORDER BY user_id ASC")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * from Users WHERE user_id = :id")
    fun getUser(id: Int): Flow<User>

    @Query("SELECT * FROM Users WHERE username = :username")
    suspend fun getUserByUsername(username: String): User?

    @Query("SELECT * FROM Users WHERE username = :email")
    suspend fun getUserByEmail(email: String): User?

    // Specify the conflict strategy as REPLACE, when the user tries to add an
    // existing User into the database Room REPLACES the conflict.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)
}