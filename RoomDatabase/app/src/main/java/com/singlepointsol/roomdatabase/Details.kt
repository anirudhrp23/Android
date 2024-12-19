package com.singlepointsol.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Details(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, val name: String)
