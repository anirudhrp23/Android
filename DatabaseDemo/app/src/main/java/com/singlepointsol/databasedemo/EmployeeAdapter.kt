package com.singlepointsol.databasedemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(val employeeArrayList: ArrayList<Employee>) : RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTv: TextView = itemView.findViewById(R.id.name_tv)
        val emailTv: TextView = itemView.findViewById(R.id.email_tv)
        val phoneTv: TextView = itemView.findViewById(R.id.phone_tv)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.emp_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeAdapter.MyViewHolder, position: Int) {
        val employee = employeeArrayList[position]
        holder.nameTv.text = employee.name
        holder.emailTv.text = employee.email
        holder.phoneTv.text = employee.phone
    }

    override fun getItemCount(): Int {
        return employeeArrayList.size
    }

}
