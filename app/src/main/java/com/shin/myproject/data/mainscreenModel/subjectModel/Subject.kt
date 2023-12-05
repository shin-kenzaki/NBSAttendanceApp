package com.shin.myproject.data.mainscreenModel.subjectModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.common.reflect.TypeToken
import com.google.gson.Gson


@Entity(tableName = "Subjects")
data class Subject(
    @ColumnInfo(name = "user_id")
    val userId: Int,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "subject_id")
    val subjectId: Int = 0,
    @ColumnInfo(name = "subject_code")
    val subjectCode: String,
    @ColumnInfo(name = "subject_name")
    val subjectName: String,
    @ColumnInfo(name = "subject_day")
    val subjectDay: List<DayListItem>,
    @ColumnInfo(name = "start_time")
    val startTime: String,
    @ColumnInfo(name = "end_time")
    val endTime: String,
    @ColumnInfo(name = "subject_description")
    val subjectDescription: String
)


class DayListItemConverter {
    @TypeConverter
    fun fromString(value: String): List<DayListItem> {
        val listType = object : TypeToken<List<DayListItem>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toString(value: List<DayListItem>): String {
        return Gson().toJson(value)
    }
}