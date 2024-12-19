package com.singlepointsol.assignmentviewcontroller

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private val itemList = ArrayList<Product>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ItemAdapter(itemList)
        recyclerView.adapter = adapter

        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return super.onCreateOptionsMenu(menu)}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
        R.id.addItemButton -> {
            showAddItemDialog()
            true
        }

        else -> super.onOptionsItemSelected(item)
    }

    }
    @SuppressLint("NotifyDataSetChanged")
    private fun showAddItemDialog() {
        val dialogView = layoutInflater.inflate(R.layout.activity_alert, null)
        val nameInput = dialogView.findViewById<EditText>(R.id.itemName)
        val priceInput = dialogView.findViewById<EditText>(R.id.itemPrice)
        val addButton = dialogView.findViewById<Button>(R.id.addItemButton)

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        addButton.setOnClickListener {
            val name = nameInput.text.toString()
            val price = priceInput.text.toString().toDoubleOrNull()

            if (name.isNotEmpty() && price != null) {
                itemList.add(Product(name, price))
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            } else {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }

        dialog.show()
        
    }
}