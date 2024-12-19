package com.singlepointsol.assignmentpictureapi

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MountainAdapter(private val mountainArrayList: ArrayList<Mountain>) : RecyclerView.Adapter<MountainAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flowerImage: ImageView = itemView.findViewById(R.id.mountain_image)
        val userName: TextView = itemView.findViewById(R.id.user_name)
        val viewCount: TextView = itemView.findViewById(R.id.view_count)
        val likesCount: TextView = itemView.findViewById(R.id.likes_count)
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mountain_list, parent, false)
        return ViewHolder(view)
    }

    fun getItemCount(): Int = mountainArrayList.size

    @SuppressLint("SetTextI18n")
    fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val flower = mountainArrayList[position]

        Glide.with(holder.itemView.context).load(flower.mountainImage).into(holder.flowerImage)

        holder.userName.text = "User: ${flower.user}"
        holder.viewCount.text = "Views: ${flower.views}"
        holder.likesCount.text = "Likes: ${flower.likes}"

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MountainActivity::class.java)
            intent.putExtra("mountainImage", flower.mountainImage)
            intent.putExtra("user", flower.user)
            intent.putExtra("views", flower.views)
            intent.putExtra("likes", flower.likes)
            holder.itemView.context.startActivity(intent)
        }
    }

}
