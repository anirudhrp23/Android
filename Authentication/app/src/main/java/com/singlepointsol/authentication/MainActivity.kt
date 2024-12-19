package com.singlepointsol.authentication

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
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var username: EditText
    private lateinit var pwd: EditText
    private lateinit var signin: Button
    private lateinit var signup: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        username = findViewById(R.id.uname_et)
        pwd = findViewById(R.id.pass_et)
        signin = findViewById(R.id.signin_button)
        signup = findViewById(R.id.signup_button)
        auth = Firebase.auth

        signin.setOnClickListener(this)
        signup.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        if (p0 != null){
            when(p0.id){
                R.id.signin_button ->{
                    val username = username.text.toString()
                    val password = pwd.text.toString()
                    auth.signInWithEmailAndPassword(username, password).addOnCompleteListener{
                        if (it.isSuccessful){
                            Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, WelcomeActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG).show()
                        }
                    }

                }
                R.id.signup_button ->{
                    val intent = Intent(this, SignUpActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}