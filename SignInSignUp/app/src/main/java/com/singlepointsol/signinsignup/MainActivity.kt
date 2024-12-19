package com.singlepointsol.signinsignup

import android.annotation.SuppressLint
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
    lateinit var userName: EditText
    lateinit var password: EditText
    lateinit var signInButton: Button
    lateinit var signUpButton: Button
    lateinit var dbHelper: DBHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        userName = findViewById(R.id.name_et)
        password = findViewById(R.id.pass_et)
        signInButton = findViewById(R.id.signin_button)
        signUpButton = findViewById(R.id.signup_button)

        signInButton.setOnClickListener(this)
        signUpButton.setOnClickListener(this)
        dbHelper = DBHelper(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.signin_button -> {
                    if (userName.text.isNotEmpty() && password.text.isNotEmpty()
                    ) {
                        val userName = userName.text.toString()
                        val password = password.text.toString()

                        // Save user to the database
                        val user = Details(userName, password, "", "")
                        val result = dbHelper.addEmployee(user)

                        if (result > -1) {
                            Toast.makeText(
                                this,
                                "User Registered Successfully!",
                                Toast.LENGTH_LONG
                            ).show()

                            val homeIntent = Intent(this, SignIn::class.java)
                            startActivity(homeIntent)
                        } else {
                            Toast.makeText(this, "Registration Failed", Toast.LENGTH_LONG).show()
                        }

                    }
                }


                R.id.signup_button -> {
                    val signupintent = Intent(this, SignUp::class.java)
                    startActivity(signupintent)
                }
            }
        }
    }
}




