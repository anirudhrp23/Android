package com.singlepointsol.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileDetails : AppCompatActivity(), View.OnClickListener {
    lateinit var name_view: TextView
    lateinit var mobile_view: TextView
    lateinit var email_view: TextView
    lateinit var designation_view: TextView
    lateinit var home_btn: Button
    lateinit var parentlayout: ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_details)
        name_view = findViewById(R.id.view_name)
        mobile_view = findViewById(R.id.view_mobile)
        email_view = findViewById(R.id.view_email)
        designation_view = findViewById(R.id.view_desigation)
        home_btn = findViewById(R.id.home_btn)

        val myvalue:String= intent.getStringExtra("name").toString()
        val myvalue1:String= intent.getStringExtra("mobile").toString()
        val myvalue2:String= intent.getStringExtra("email").toString()
        val myvalue3:String= intent.getStringExtra("designation").toString()
        name_view.text=myvalue
        mobile_view.text=myvalue1
        email_view.text=myvalue2
        designation_view.text=myvalue3
        home_btn.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}