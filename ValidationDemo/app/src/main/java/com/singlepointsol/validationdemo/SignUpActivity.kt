package com.singlepointsol.validationdemo

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var username1: EditText
    lateinit var pw1: EditText
    lateinit var submit: Button
    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        username1 = findViewById(R.id.username_et)
        pw1 = findViewById(R.id.pw1_et)
        submit = findViewById(R.id.submit_btn)

        submit.setOnClickListener(this)
        sharedPref = getSharedPreferences("SpsPref1", MODE_PRIVATE)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.submit_btn -> {
                    val editor: SharedPreferences.Editor = sharedPref.edit()
                    editor.putString("userKey", username1.text.toString())
                    editor.putString("pw1Key", pw1.text.toString())
                    editor.apply()
                    username1.text.clear()
                    pw1.text.clear()
                }
            }
        }

    }
}