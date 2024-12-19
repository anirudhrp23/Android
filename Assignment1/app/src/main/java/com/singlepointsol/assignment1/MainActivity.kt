package com.singlepointsol.assignment1

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var phone:EditText
    lateinit var email:EditText
    lateinit var designation:EditText
    lateinit var submit:Button
    lateinit var value1:TextView
    lateinit var value2:TextView
    lateinit var value3:TextView
    lateinit var value4:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.name_et)
        phone = findViewById(R.id.phone_et)
        email = findViewById(R.id.email_et)
        designation = findViewById(R.id.designation_et)
        submit = findViewById(R.id.submit)
        value1 = findViewById(R.id.name_tv)
        value2 = findViewById(R.id.phone_tv)
        value3 = findViewById(R.id.email_tv)
        value4 = findViewById(R.id.designation_tv)

        submit.setOnClickListener(View.OnClickListener {
            val v1:String = name.text.toString()
            value1.text = v1
            val v2:String = phone.text.toString()
            value2.text = v2
            val v3:String = email.text.toString()
            value3.text = v3
            val v4:String = designation.text.toString()
            value4.text = v4

            name.setText("")
            phone.setText("")
            email.setText("")
            designation.setText("")
        })


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}