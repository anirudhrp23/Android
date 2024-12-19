package com.singlepointsol.f1drivers

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

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var carId: EditText
    lateinit var driverName: EditText
    lateinit var teamName: EditText
    lateinit var submitButton: Button
    lateinit var loadButton: Button
    lateinit var updateButton: Button
    lateinit var deleteButton: Button
    lateinit var dbHelper: DbHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        carId = findViewById(R.id.car_no_et)
        driverName = findViewById(R.id.name_et)
        teamName = findViewById(R.id.team_et)
        submitButton = findViewById(R.id.submit_button)
        loadButton = findViewById(R.id.load_button)
        updateButton = findViewById(R.id.update_button)
        deleteButton = findViewById(R.id.delete_button)

        submitButton.setOnClickListener(this)
        loadButton.setOnClickListener(this)
        updateButton.setOnClickListener(this)
        deleteButton.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        if (p0 != null)
            when (p0.id) {
                R.id.submit_button -> {
                    if (carId.text.toString().isEmpty() || driverName.text.toString()
                            .isEmpty() || teamName.text.toString().isEmpty()
                    ) {
                        val drivers = Drivers(
                            carId.text.toString(),
                            driverName.text.toString(),
                            teamName.text.toString()
                        )
                        val result = dbHelper.addDriver(drivers)
                        if (result > 0) {
                            Toast.makeText(this, "Driver Registered", Toast.LENGTH_LONG).show()
                            carId.text.clear()
                            driverName.text.clear()
                            teamName.text.clear()
                        } else {
                            Toast.makeText(this, "Provide Required Details", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }

                R.id.load_button -> {
                    val intent = Intent(this, DriverDetails::class.java)
                    startActivity(intent)
                }

                R.id.update_button -> {
                    if (carId.text.toString().isNotEmpty() && driverName.text.toString()
                            .isNotEmpty() && teamName.text.toString().isNotEmpty()
                    ) {
                        val isUpdated: Boolean = dbHelper.updateDriver(
                            carId.text.toString().toInt(),
                            driverName.text.toString(), teamName.text.toString())
                        if (isUpdated) {
                            Toast.makeText(this, "Driver Updated", Toast.LENGTH_LONG).show()
                            carId.text.clear()
                            driverName.text.clear()
                            teamName.text.clear()
                        } else {
                            Toast.makeText(this, "Driver Not Updated", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(this, "Please provide all fields", Toast.LENGTH_LONG).show()
                    }


                }

                R.id.delete_button -> {
                    val isDeleted: Boolean = dbHelper.deleteDriver(carId.text.toString().toInt())
                    if (isDeleted) {
                        Toast.makeText(this, "Driver Deleted", Toast.LENGTH_LONG).show()
                        carId.text.clear()
                        driverName.text.clear()
                        teamName.text.clear()
                    } else {
                        Toast.makeText(this, "Driver Not Deleted", Toast.LENGTH_LONG).show()
                    }
                }
            }


    }
}
