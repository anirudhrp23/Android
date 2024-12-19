package com.singlepointsol.recyclerassignment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VersionAdapter(val versionsArrayList: ArrayList<Version>) : RecyclerView.Adapter<VersionAdapter.ViewHolder>() {
    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.findViewById<ImageView>(R.id.car_image_view)
        val textView = view.findViewById<TextView>(R.id.model_text_view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return versionsArrayList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val version = versionsArrayList[position]
        holder.imageView.setImageResource(version.vImage)
        holder.textView.text = version.vName

        holder.imageView.setOnClickListener{
            val context = holder.imageView.context
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("position", version.vImage)
            intent.putExtra("name", version.vName)
            context.startActivity(intent)
        }

    }

}
