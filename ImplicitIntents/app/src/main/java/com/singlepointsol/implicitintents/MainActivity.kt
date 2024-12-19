package com.singlepointsol.implicitintents

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
    lateinit var call: Button
    lateinit var dial: Button
    lateinit var browse: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        call = findViewById(R.id.call_button)
        dial = findViewById(R.id.dial_button)
        browse = findViewById(R.id.browse_button)


        call.setOnClickListener(this)
        dial.setOnClickListener(this)
        browse.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.call_button -> {
                    val callIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel:1234567890"))
                    startActivity(callIntent)
                }
                    R.id.dial_button ->{
                        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567890"))
                        startActivity(dialIntent)
                    }
                    R.id.browse_button ->{
                        val browseIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.android.com/"))
                        startActivity(browseIntent)
                    }
                }
            }
        }
    }
