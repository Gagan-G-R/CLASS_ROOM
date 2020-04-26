package com.example.class_room

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.class_info.*
import kotlinx.android.synthetic.main.student_info.*

class AddClass: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.class_info)
        Submit_Button222.setOnClickListener {
            Toast.makeText(this,"Submitted", Toast.LENGTH_SHORT).show()
            val database1 = Room.databaseBuilder(
                this,
                StudentsDatabase::class.java,
                "student_database"
            ).allowMainThreadQueries()
                .build()
            val allStudents = database1.studentsDao().getAllStudents()
            allStudents.forEach {
                if(it.sec.contains("/"+S_SEC222.text.toString().toUpperCase())){
                    database1.studentsDao().deleteStudents(ListOfStudents(it.no,it.name,it.id,it.sec))
                }
            }

            database1.studentsDao().insetStudents(ListOfStudents(S_ID222.text.toString().toInt()*1000,S_NAME222.text.toString(), S_ID222.text.toString(), "/"+S_SEC222.text.toString().toUpperCase()))

            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}
