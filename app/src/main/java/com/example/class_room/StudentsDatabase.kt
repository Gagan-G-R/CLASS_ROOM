package com.example.class_room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ListOfStudents::class],version = 2)
abstract class StudentsDatabase : RoomDatabase()     {
    abstract fun studentsDao():StudentsDao
}