package com.singlepointsol.relationsdb

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EmpDetailsActivity : AppCompatActivity(), ValueEventListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var employeeArrayList: ArrayList<Employee>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_emp_details)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        employeeArrayList = ArrayList()
        getEmployee()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getEmployee() {
        dbRef = FirebaseDatabase.getInstance().getReference("Employee")
        dbRef.addValueEventListener(this)

    }

    override fun onDataChange(snapshot: DataSnapshot) {
        if (snapshot.exists()) {
            for (userSnapshot in snapshot.children) {
                val employee = userSnapshot.getValue(Employee::class.java)
                if (employee != null) {
                    employeeArrayList.add(employee)
                }
            }
            recyclerView.adapter = EmployeeAdapter(employeeArrayList)

        }
    }

    override fun onCancelled(error: DatabaseError) {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
    }
}