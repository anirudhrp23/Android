package com.singlepointsol.assignmentpictureapi

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MountainActivity: AppCompatActivity() {
    private lateinit var mountainImageView: ImageView
    private lateinit var userName: TextView
    private lateinit var viewCount: TextView
    private lateinit var likesCount: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mountain)

        mountainImageView = findViewById(R.id.mountain_imageView)
        userName = findViewById(R.id.user_name)
        viewCount = findViewById(R.id.view_count)
        likesCount = findViewById(R.id.likes_count)

        val imageUrl = intent.getStringExtra("flowerImage")
        val user = intent.getStringExtra("user")
        val views = intent.getIntExtra("views", 0)
        val likes = intent.getIntExtra("likes", 0)

        Glide.with(this).load(imageUrl).into(mountainImageView)

        userName.text = "User: $user"
        viewCount.text = "Views: $views"
        likesCount.text = "Likes: $likes"
    }
}