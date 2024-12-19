package com.singlepointsol.signinsignup

import android.annotation.SuppressLint
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

class SignUp : AppCompatActivity(), View.OnClickListener {
    lateinit var userName1: EditText
    lateinit var password1: EditText
    lateinit var email: EditText
    lateinit var phone: EditText
    lateinit var submitButton: Button
    lateinit var homeButton: Button
    lateinit var dbHelper: DBHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        userName1 = findViewById(R.id.uname_et)
        password1 = findViewById(R.id.pwd_et)
        email = findViewById(R.id.email_et)
        phone = findViewById(R.id.phone_et)
        submitButton = findViewById(R.id.submit_button)
        homeButton = findViewById(R.id.home_button)

        submitButton.setOnClickListener(this)
        homeButton.setOnClickListener(this)
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
                R.id.submit_button -> {
                    if (userName1.text.isNotEmpty() && password1.text.isNotEmpty() &&
                        email.text.isNotEmpty() && phone.text.isNotEmpty()
                    ) {
                        val userName = userName1.text.toString()
                        val password = password1.text.toString()
                        val emailText = email.text.toString()
                        val phoneText = phone.text.toString()

                        // Save user to the database
                        val user = Details(userName, password, emailText, phoneText)
                        val result:Long = dbHelper.addEmployee(user)

                        if (result > -1) {
                            Toast.makeText(
                                this,
                                "User Registered Successfully!",
                                Toast.LENGTH_LONG
                            ).show()

                            // Clear input fields
                            userName1.text.clear()
                            password1.text.clear()
                            email.text.clear()
                            phone.text.clear()

                            // Navigate to the MainActivity
                            val homeIntent = Intent(this, MainActivity::class.java)
                            startActivity(homeIntent)
                        } else {
                            Toast.makeText(this, "Registration Failed", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()
                    }
                }

                R.id.home_button -> {
                    var homeintent = Intent(this, MainActivity::class.java)
                    startActivity(homeintent)

                }

            }
        }
    }
}