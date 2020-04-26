package com.example.class_room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentsDao {
    @Query("SELECT * FROM ListOfStudents")
    fun getAllStudents():List<ListOfStudents>
    @Insert
    fun insetStudents(students: ListOfStudents)
    @Delete
    fun deleteStudents(students: ListOfStudents)
}