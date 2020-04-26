package com.example.class_room
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.class_info.*
import kotlinx.android.synthetic.main.student_info.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL
import java.util.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        goToStudentInfo.setOnClickListener {
            startActivity(Intent(this, AddStudents::class.java))
        }
        button2.setOnClickListener {
            startActivity(Intent(this, AddClass::class.java))
        }
        val database1 = Room.databaseBuilder(
            this,
            StudentsDatabase::class.java,
            "student_database"
        ).allowMainThreadQueries()
            .build()
        val allStudents = database1.studentsDao().getAllStudents()

        var num = 0
        toggleButton.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                num=0
                toggleButton.setText("A")
                Toast.makeText(this,"Class A",Toast.LENGTH_SHORT).show()
                LatestStudent.setText("")
                LatestClass.text=""
                allStudents.forEach {
                   if (it.sec=="A") {

                           LatestStudent.append("${it.name}\t--\t${it.id}\t--\t${it.sec}\n\n")

                        num = num + 1
                    }
                    if(it.sec.contains("/A", ignoreCase = true)){
                        LatestClass.text=" "
                        LatestClass.append("Class Teacher:${it.name}\t\n\tRoom No:${it.id}\n")
                    }
                }
                LatestMess.text="TOTAL=$num"
                StudentsRV.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = StudentsAdapter(allStudents,"A",num)
                }
            }
            else{
                num=0
                toggleButton.setText("B")
                LatestStudent.setText("")
                LatestClass.text=""
                Toast.makeText(this,"Class B",Toast.LENGTH_SHORT).show()

                allStudents.forEach {
                    if (it.sec=="B") {

                            LatestStudent.append("${it.name}\t--\t${it.id}\t--\t${it.sec}\n\n")

                        num = num + 1
                    }
                    if(it.sec.contains("/B", ignoreCase = true)){
                        LatestClass.text=""
                        LatestClass.append("Class Teacher:${it.name}\t\n\tRoom No:${it.id}\n")
                    }
                }
                LatestMess.text="TOTAL=$num"
                StudentsRV.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = StudentsAdapter(allStudents,"B",num)
                }
            }
        }

    }
}
//val info = getSharedPreferences("database", Context.MODE_PRIVATE)
// val savedname = info.getString("S_NAME", "None")
//val savedid = info.getString("S_ID", "None")
//val savedsec = info.getString("S_SEC", "None")
//database1.studentsDao().insetStudents(ListOfStudents(1,"$savedname","$savedid","$savedsec"))
//d("Gagan","the size of allStudents is :${allStudents.size}")
//d("Gagan01", "the saved name of the student is : $savedname")
//  lifecycleScope.launch(Dispatchers.Main){
//     val mess = URL("https://finepointmobile.com/api/inventory/v1/message").readText()
//       d("Gagan02","the mess is :$mess")
//      LatestMess.text=mess
// }
//val students = mutableListOf(
//    ListOfStudents(1,"Gagan","15","A"),
//    ListOfStudents(2,"Chandana","12","A"),
//    ListOfStudents(3,"Vani","56","B"),
//    ListOfStudents(4,"Rajesh","34","B")
// students.add(ListOfStudents(1,"$savedname","$savedid","$savedsec"))