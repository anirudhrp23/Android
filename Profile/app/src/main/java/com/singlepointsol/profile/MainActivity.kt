package com.singlepointsol.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var name1: EditText
    lateinit var mobile: EditText
    lateinit var email: EditText
    lateinit var designation: EditText
    lateinit var submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        name1 = findViewById(R.id.name_et)
        mobile = findViewById(R.id.mobile_et)
        email = findViewById(R.id.email_et)
        designation = findViewById(R.id.designation_et)
        submit = findViewById(R.id.submit_btn)
        submit.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        if (name1.text.isNotEmpty() && mobile.text.isNotEmpty() && email.text.isNotEmpty() && designation.text.isNotEmpty()){
         val intent = Intent(this, ProfileDetails::class.java)
         intent.putExtra("name", name1.text.toString())
         intent.putExtra("mobile", mobile.text.toString())
         intent.putExtra("email", email.text.toString())
         intent.putExtra("designation", designation.text.toString())
         startActivity(intent)
    } else{
        Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_LONG).show()
    }

        }
}