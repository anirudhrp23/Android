package com.singlepointsol.relationsdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.singlepointsol.relationsdb.Employee
import java.util.ArrayList

class EmployeeAdapter(private val employeeArrayList: ArrayList<Employee>) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTv = itemView.findViewById<TextView>(R.id.name_tv)
        val emailTv = itemView.findViewById<TextView>(R.id.email_tv)
        val phoneTv = itemView.findViewById<TextView>(R.id.phone_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.emp_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return employeeArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employee = employeeArrayList[position]
        holder.nameTv.text = employee.name
        holder.emailTv.text = employee.email
        holder.phoneTv.text = employee.phone
    }

}
