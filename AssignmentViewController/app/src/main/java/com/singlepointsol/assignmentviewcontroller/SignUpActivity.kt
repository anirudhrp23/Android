package com.singlepointsol.assignmentviewcontroller

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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var name1: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var cpass: EditText
    lateinit var save: Button
    lateinit var auth: FirebaseAuth


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        name1 = findViewById(R.id.et_name)
        email = findViewById(R.id.et_email)
        password = findViewById(R.id.password_et)
        cpass = findViewById(R.id.cpass_et)
        save = findViewById(R.id.save_button)
        auth = Firebase.auth

        save.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.save_button -> {
                    if (name1.text.toString().isNotEmpty()
                        && email.text.toString().isNotEmpty()
                        && password.text.toString().isNotEmpty()
                        && cpass.text.toString().isNotEmpty()
                    ) {
                        if (password.text.toString() == cpass.text.toString())
                            auth.createUserWithEmailAndPassword(
                                email.text.toString(),
                                password.text.toString()
                            ).addOnCompleteListener {
                                if (it.isSuccessful) {
                                    Toast.makeText(
                                        this,
                                        "Successfully Registered",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    val intent = Intent(this, MainActivity::class.java)
                                    startActivity(intent)
                                }
                            }
                    } else {
                        Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_LONG).show()
                    }
                    name1.text.clear()
                    email.text.clear()
                    password.text.clear()
                    cpass.text.clear()
                }

            }
        }
    }
}