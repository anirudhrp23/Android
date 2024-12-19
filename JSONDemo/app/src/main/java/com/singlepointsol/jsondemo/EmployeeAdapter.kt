package com.singlepointsol.jsondemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(private val employeesArray: ArrayList<Employee>) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textName: TextView = view.findViewById(R.id.text_name)
        val textEmail: TextView = view.findViewById(R.id.text_email)
        val textPhone: TextView = view.findViewById(R.id.text_phone)
        val textDesignation: TextView = view.findViewById(R.id.text_designation)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.employee_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employee = employeesArray[position]
        holder.textName.text = employee.name
        holder.textEmail.text = employee.email
        holder.textPhone.text = employee.phone
        holder.textDesignation.text = employee.designation
    }

    override fun getItemCount(): Int {
        return employeesArray.size
    }



}
