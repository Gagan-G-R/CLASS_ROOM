package com.example.class_room

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.student_info.*

class AddStudents : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.student_info)
        btn_cam.setOnClickListener {
            var  i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,123)
        }
        Submit_Button.setOnClickListener {
            Toast.makeText(this,"Submitted",Toast.LENGTH_SHORT).show()
           // val info_main = getSharedPreferences("database", Context.MODE_PRIVATE)
           // info_main.edit().apply {
           //     putString("S_NAME", S_NAME111.text.toString())
           //     putString("S_ID", S_ID111.text.toString())
           //     putString("S_SEC", S_SEC111.text.toString().toUpperCase())

           // }.apply()

            val database1 = Room.databaseBuilder(
                this,
                StudentsDatabase::class.java,
                "student_database"
            ).allowMainThreadQueries()
                .build()
            database1.studentsDao().insetStudents(ListOfStudents(S_ID111.text.toString().toInt(),S_NAME111.text.toString(), S_ID111.text.toString(), S_SEC111.text.toString().toUpperCase()))
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 123) {
            var bmp = data?.extras?.get("data") as Bitmap
            iv_cam.setImageBitmap(bmp)
        }
    }
}





