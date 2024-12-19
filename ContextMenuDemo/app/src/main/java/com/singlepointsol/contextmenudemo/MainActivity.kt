package com.singlepointsol.contextmenudemo

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var contextBtn: Button
    lateinit var titleText: TextView
    lateinit var parentLayout: ConstraintLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        contextBtn = findViewById<Button>(R.id.context_button)
        titleText = findViewById<TextView>(R.id.title_text)
        parentLayout = findViewById<ConstraintLayout>(R.id.main)
        registerForContextMenu(contextBtn)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context_menu, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.text_item -> {
                val updated = "updated text"
                titleText.text = updated
                true
            }
            R.id.color_item -> {
                contextBtn.setBackgroundColor(Color.RED)
                true
            }
            R.id.background_item -> {
                parentLayout.setBackgroundResource(R.drawable.android)
                true
            }

            else -> {
                return super.onContextItemSelected(item)
            }
        }
    }
}