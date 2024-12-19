package com.singlepointsol.customrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VersionAdapter(val versionsArray: ArrayList<Version>) : RecyclerView.Adapter<VersionAdapter.ViewHolder>() {
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val versionImage = view.findViewById<ImageView>(R.id.version_image)
        val versionName = view.findViewById<TextView>(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return versionsArray.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val version = versionsArray[position]
        holder.versionImage.setImageResource(version.vImage)
        holder.versionName.text = version.vName

    }

}
