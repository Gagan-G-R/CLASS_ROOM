package com.example.class_room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.student_row.view.*

class StudentsAdapter( val allStudents: List<ListOfStudents>, val a:String,val b:Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = allStudents.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

            holder.itemView.NaMe.text = allStudents[position].id+"--"+allStudents[position].name+"--"+allStudents[position].sec

    }

}


