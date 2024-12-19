package com.singlepointsol.recyclerassignment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var versionsArrayList: ArrayList<Version>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        versionsArrayList = ArrayList()
        versionsArrayList.add(Version(R.drawable.c_class,"C Class"))
        versionsArrayList.add(Version(R.drawable.glc,"GLC SUV"))
        versionsArrayList.add(Version(R.drawable.e_class,"E Class"))
        versionsArrayList.add(Version(R.drawable.gle,"GLE AMG Coupe"))
        versionsArrayList.add(Version(R.drawable.gls,"GLS SUV"))
        versionsArrayList.add(Version(R.drawable.eqs,"EQS"))
        versionsArrayList.add(Version(R.drawable.s_class,"S Class"))
        versionsArrayList.add(Version(R.drawable.s63,"S63 AMG"))
        versionsArrayList.add(Version(R.drawable.g63,"G63 AMG"))

        recyclerView.adapter = VersionAdapter(versionsArrayList)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}