package com.example.class_room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ListOfStudents (
    @PrimaryKey (autoGenerate = true) val no : Int,
    val name : String,
    val id : String,
    val sec : String

)