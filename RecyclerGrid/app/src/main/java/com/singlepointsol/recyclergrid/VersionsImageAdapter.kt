package com.singlepointsol.recyclergrid

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class VersionsImageAdapter(val versionsImageArray: Array<Int>) : RecyclerView.Adapter<VersionsImageAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val versionImageView = itemView.findViewById<ImageView>(R.id.version_image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return versionsImageArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.versionImageView.setImageResource(versionsImageArray[position])
        holder.versionImageView.setOnClickListener(View.OnClickListener{
            val intent = Intent(it.context,DetailsActivity::class.java)
            intent.putExtra("image",versionsImageArray[position])
            it.context.startActivity(intent)
        })
    }

}
