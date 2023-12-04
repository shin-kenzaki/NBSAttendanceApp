package com.shin.myproject.data.mainscreenModel.subjectModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Subjects")
data class Subject(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "subject_id")
    val subjectId: Long = 0,
    @ColumnInfo(name = "user_id")
    val userId: Long,
    @ColumnInfo(name = "subject_code")
    val subjectCode: String,
    @ColumnInfo(name = "subject_name")
    val subjectName: String,
    @ColumnInfo(name = "subject_day")
    val subjectDay: String,
    @ColumnInfo(name = "start_time")
    val startTime: String,
    @ColumnInfo(name = "end_time")
    val endTime: String,
    @ColumnInfo(name = "subject_description")
    val subjectDescription: String
)