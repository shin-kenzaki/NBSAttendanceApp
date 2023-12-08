package com.shin.myproject.data.authModel

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "currentuser") // Ensure the table name is lowercase
data class CurrentUser(
    @PrimaryKey val userId: Int,
    val username: String,
    val password: String,
    val firstname: String,
    val lastname: String,
    val phone: String,
    val email: String,
    val school: String,
    val department: String
)