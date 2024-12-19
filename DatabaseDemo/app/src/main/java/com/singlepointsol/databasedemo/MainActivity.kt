package com.singlepointsol.databasedemo

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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var nameEdit: EditText
    private lateinit var emailEdit: EditText
    private lateinit var phoneEdit: EditText
    private lateinit var saveButton: Button
    private lateinit var loadButton: Button
    private lateinit var updateButton: Button
    private lateinit var deleteButton: Button
    private lateinit var empDBHelper: EmpDBHelper
    private lateinit var colId: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        nameEdit = findViewById(R.id.name_edit)
        emailEdit = findViewById(R.id.email_edit)
        phoneEdit = findViewById(R.id.phone_edit)
        saveButton = findViewById(R.id.save_button)
        loadButton = findViewById(R.id.load_button)
        updateButton = findViewById(R.id.update_button)
        deleteButton = findViewById(R.id.delete_button)
        colId = findViewById(R.id.col_id)

        saveButton.setOnClickListener(this)
        loadButton.setOnClickListener(this)
        updateButton.setOnClickListener(this)
        deleteButton.setOnClickListener(this)
        empDBHelper = EmpDBHelper(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        if (p0 != null)
            when (p0.id) {
                R.id.save_button -> {
                    if (nameEdit.text.isNotEmpty() && emailEdit.text.isNotEmpty() && phoneEdit.text.isNotEmpty()) {
                        val employee = Employee(
                            nameEdit.text.toString(),
                            emailEdit.text.toString(),
                            phoneEdit.text.toString()
                        )
                        val result: Long = empDBHelper.addEmployee(employee)
                        if (result > -1)
                            Toast.makeText(
                                applicationContext,
                                "Data Added Successfully",
                                Toast.LENGTH_LONG
                            ).show()
                        colId.text.clear()
                        nameEdit.text.clear()
                        emailEdit.text.clear()
                        phoneEdit.text.clear()
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "Please fill all fields",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                R.id.load_button -> {
                    val intent = Intent(this, EmployeeDetails::class.java)
                    startActivity(intent)
                }

                R.id.update_button -> {
                    if (colId.text.isNotEmpty() && nameEdit.text.isNotEmpty() && emailEdit.text.isNotEmpty() && phoneEdit.text.isNotEmpty()) {
                        val isUpdated : Boolean = empDBHelper.updateEmployee(colId.text.toString(), nameEdit.text.toString(), emailEdit.text.toString(), phoneEdit.text.toString())
                        if (isUpdated) {
                            Toast.makeText(applicationContext, "Data Updated Successfully", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(applicationContext, "Data Not Updated", Toast.LENGTH_LONG).show()
                    }
                }

                R.id.delete_button -> {
                    val isDeleted = empDBHelper.deleteEmployee(colId.text.toString())
                    if (isDeleted > 0) {
                        Toast.makeText(applicationContext, "Data Deleted Successfully", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(applicationContext, "Data Not Found", Toast.LENGTH_LONG).show()
                    }
                }
            }
    }
}

