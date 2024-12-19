package com.singlepointsol.recyclerdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DriverAdapter(val versionsArray: Array<String>) : RecyclerView.Adapter<DriverAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val versionName: TextView = itemView.findViewById(R.id.version_name_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: DriverAdapter.ViewHolder, position: Int) {
        holder.versionName.text = versionsArray[position]

    }

    override fun getItemCount(): Int {
        return versionsArray.size

    }

}
