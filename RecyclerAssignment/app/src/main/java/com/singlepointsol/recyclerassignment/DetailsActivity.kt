package com.singlepointsol.recyclerassignment

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsActivity : AppCompatActivity() {
    lateinit var versionImageView: ImageView
    lateinit var versionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        val versionImageView = findViewById<ImageView>(R.id.imageView)
        val versionTextView = findViewById<TextView>(R.id.textView)
        val selectedPosition = intent.getIntExtra("position", 0)
        versionImageView.setImageResource(selectedPosition)
        versionTextView.text = intent.getStringExtra("name")



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}