package com.singlepointsol.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Details::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun Dao(): Dao
}