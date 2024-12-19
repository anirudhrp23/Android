package com.singlepointsol.sharedpreferences

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
    lateinit var nameEditText:EditText
    lateinit var passwordEditText: EditText
    lateinit var loadButton: Button
    lateinit var saveButton: Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.name_editText)
        passwordEditText = findViewById(R.id.password_editText)
        loadButton = findViewById(R.id.load_button)
        saveButton = findViewById(R.id.save_button)

        loadButton.setOnClickListener(this)
        saveButton.setOnClickListener(this)
        sharedPreferences = getSharedPreferences("Spspreferences", MODE_PRIVATE)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.load_button -> {
                    if (sharedPreferences.contains("nameKey")) {
                        nameEditText.setText(sharedPreferences.getString("nameKey", ""))
                    }
                    else{
                        Toast.makeText(this,"Empty Preference",Toast.LENGTH_LONG).show()
                    }

                    if (sharedPreferences.contains("passwordKey")) {
                        passwordEditText.setText(sharedPreferences.getString("passwordKey", ""))

                    }
                    else{
                        Toast.makeText(this,"Empty Preference",Toast.LENGTH_LONG).show()
                    }

                }
                R.id.save_button -> {
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("nameKey", nameEditText.text.toString())
                    editor.putString("passwordKey", passwordEditText.text.toString())
                    editor.apply()
                    nameEditText.text.clear()
                    passwordEditText.text.clear()
                }
            }
        }
        }
    }
