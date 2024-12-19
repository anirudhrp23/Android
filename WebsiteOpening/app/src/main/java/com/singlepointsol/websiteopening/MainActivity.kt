package com.singlepointsol.websiteopening

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var honda:Button
    lateinit var triumph:Button
    lateinit var ducati:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        honda = findViewById(R.id.honda_btn)
        triumph = findViewById(R.id.triumph_btn)
        ducati = findViewById(R.id.ducati_btn)

        honda.setOnClickListener(this)
        triumph.setOnClickListener(this)
        ducati.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when(view.id){
                R.id.honda_btn -> {
                    val hondaIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hondabigwing.in/"))
                    startActivity(hondaIntent)

            }
                R.id.triumph_btn -> {
                    val triumphIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.triumphmotorcycles.in/"))
                    startActivity(triumphIntent)
            }
                R.id.ducati_btn -> {
                    val ducatiIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ducati.com/in/en/home"))
                    startActivity(ducatiIntent)
            }
            }
        }

    }
}