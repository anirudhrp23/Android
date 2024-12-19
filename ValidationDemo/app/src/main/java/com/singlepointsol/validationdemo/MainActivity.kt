package com.singlepointsol.validationdemo

import android.content.Intent
import android.content.SharedPreferences
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
    lateinit var userNameEditText: EditText
    lateinit var password: EditText
    lateinit var signin: Button
    lateinit var signup: Button
    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        userNameEditText = findViewById(R.id.uname_et)
        password = findViewById(R.id.pass_et)
        signin = findViewById(R.id.signin_btn)
        signup = findViewById(R.id.signup_btn)

        signin.setOnClickListener(this)
        signup.setOnClickListener(this)
        sharedPref = getSharedPreferences("SpsPref1", MODE_PRIVATE)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.signin_btn -> {
                    if (sharedPref.getString("userKey", null) == userNameEditText.text.toString() && sharedPref.getString("pw1Key", null) == password.text.toString()) {
                            val welcomeIntent = Intent(this, WelcomeActivity::class.java)
                            startActivity(welcomeIntent)
                    }
                        else
                    {
                        Toast.makeText(this, "Please enter valid credentials", Toast.LENGTH_LONG).show()
                    }
                    }
                R.id.signup_btn -> {
                    val signupIntent = Intent(this, SignUpActivity::class.java)
                    startActivity(signupIntent)
                }
            }
        }
    }
}
