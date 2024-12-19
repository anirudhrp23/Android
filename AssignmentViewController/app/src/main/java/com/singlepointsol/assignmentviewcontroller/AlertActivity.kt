package com.singlepointsol.assignmentviewcontroller

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AlertActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var itemName: EditText
    lateinit var itemPrice: EditText
    lateinit var addItemButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alert)
        itemName = findViewById(R.id.itemName)
        itemPrice = findViewById(R.id.itemPrice)
        addItemButton = findViewById(R.id.addItemButton)
        addItemButton.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        if (p0 != null)
            when (p0.id) {
                R.id.addItemButton -> {
                    val name = itemName.text.toString()
                    val price = itemPrice.text.toString()
                }
            }
    }
}