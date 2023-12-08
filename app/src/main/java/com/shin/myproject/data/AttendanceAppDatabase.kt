package com.shin.myproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shin.myproject.data.authModel.CurrentUser
import com.shin.myproject.data.authModel.User
import com.shin.myproject.data.mainscreenModel.studentModel.Student
import com.shin.myproject.data.mainscreenModel.subjectModel.DayListItemConverter
import com.shin.myproject.data.mainscreenModel.subjectModel.Subject
import com.shin.myproject.user.dao.CurrentUserDao
import com.shin.myproject.user.dao.StudentDao
import com.shin.myproject.user.dao.SubjectDao
import com.shin.myproject.user.dao.UserDao

/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [User::class, Subject::class, Student::class, CurrentUser::class], version = 3, exportSchema = false)
@TypeConverters(DayListItemConverter::class)
abstract class AttendanceAppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun subjectDao(): SubjectDao
    abstract fun studentDao(): StudentDao
    abstract fun currentUserDao(): CurrentUserDao


    companion object {
        @Volatile
        private var Instance: AttendanceAppDatabase? = null

        fun getDatabase(context: Context): AttendanceAppDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AttendanceAppDatabase::class.java, "nbs_database")
                    /**
                     * Setting this option in your app's database builder means that Room
                     * permanently deletes all data from the tables in your database when it
                     * attempts to perform a migration with no defined migration path.
                     */
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}