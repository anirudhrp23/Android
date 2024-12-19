package com.singlepointsol.f1drivers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class DriversAdapter(val driversArrayList: ArrayList<Drivers>) : RecyclerView.Adapter<DriversAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val carNo = view.findViewById<EditText>(R.id.car_no_et)
        val name = view.findViewById<EditText>(R.id.name_et)
        val team = view.findViewById<EditText>(R.id.team_et)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return driversArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val driver = driversArrayList[position]
        holder.carNo.setText(driver.carNo)
        holder.name.setText(driver.name)
        holder.team.setText(driver.team)
    }

}
