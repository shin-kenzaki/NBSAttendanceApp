package com.shin.myproject.data.authModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val userId: Int,
    val firstname: String,
    val lastname: String,
    val username: String,
    val password: String,
    val email: String,
    val phone: String,
    val school: String,
    val department: String
)