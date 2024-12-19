package com.singlepointsol.glidedemo

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    lateinit var sampleImage: ImageView
    lateinit var secondImage: ImageView
    lateinit var thirdImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        sampleImage = findViewById(R.id.sample_imageView)
        secondImage = findViewById(R.id.s2_imageView)
        thirdImage = findViewById(R.id.s3_imageView)

        Glide.with(this).load("https://www.motopinas.com/images/posts/post14107.jpg").placeholder(R.drawable.ic_launcher_foreground).into(sampleImage)
        Glide.with(this).load("https://th.bing.com/th/id/OIP.5voAqddtIfi6213uB1tRcgAAAA?rs=1&pid=ImgDetMain").into(secondImage)
        Glide.with(this).load("https://th.bing.com/th/id/OIP.mZlHBg5fjH8_X-1bwMhvZQHaE8?rs=1&pid=ImgDetMain").into(thirdImage)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}