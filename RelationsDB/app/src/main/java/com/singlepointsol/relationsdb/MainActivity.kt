package com.singlepointsol.relationsdb

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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var empId: EditText
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var phone: EditText
    lateinit var saveButton: Button
    lateinit var loadButton: Button
    private lateinit var database: FirebaseDatabase
    private lateinit var myRef: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        empId = findViewById(R.id.emp_id_et)
        name = findViewById(R.id.name_et)
        email = findViewById(R.id.email_et)
        phone = findViewById(R.id.phone_et)
        saveButton = findViewById(R.id.save_button)
        loadButton = findViewById(R.id.load_button)

        saveButton.setOnClickListener(this)
        loadButton.setOnClickListener(this)
        database = Firebase.database
        myRef = database.reference.child("Employee")

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
                    if (empId.text.toString().isNotEmpty() && name.text.toString().isNotEmpty() && email.text.toString().isNotEmpty() && phone.text.toString().isNotEmpty())
                    {
                        val employee = Employee( empId.text.toString(), name.text.toString(), email.text.toString(), phone.text.toString())
                        myRef.push().setValue(employee)
                        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show()
                        empId.text.clear()
                        name.text.clear()
                        email.text.clear()
                        phone.text.clear()

                    }
                }
                R.id.load_button -> {
                    val intent = Intent(this, EmpDetailsActivity::class.java)
                    startActivity(intent)
                }
            }

        }
    }
}