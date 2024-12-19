package com.singlepointsol.datapassing

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), OnClickListener {
    lateinit var data: EditText
    lateinit var submit: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        data = findViewById(R.id.data_et)
        submit = findViewById(R.id.button)
        submit.setOnClickListener (this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (data.text.isNotEmpty()) {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("data", data.text.toString())
            startActivity(intent)
        } else {
            Toast.makeText(this, "Please Enter Data", Toast.LENGTH_SHORT).show()
        }
    }
}