package com.singlepointsol.f1drivers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)  {
    companion object{
        const val DATABASE_NAME = "f1.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "drivers"
        const val KEY_ID = "id"
        const val KEY_CAR_NO = "car_no"
        const val KEY_NAME = "name"
        const val KEY_TEAM = "team"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT, $KEY_CAR_NO TEXT, $KEY_NAME TEXT, $KEY_TEAM TEXT)"
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
    fun addDriver(driver:Drivers):Long{
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_CAR_NO, driver.carNo)
        contentValues.put(KEY_NAME, driver.name)
        contentValues.put(KEY_TEAM, driver.team)
        return db.insert(TABLE_NAME, null, contentValues)
    }
    fun getDrivers():ArrayList<Drivers>{
        val driversArrayList: ArrayList<Drivers> = ArrayList()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        while (cursor.moveToNext()){
            val carNo = cursor.getString(1)
            val name = cursor.getString(2)
            val team = cursor.getString(3)
            driversArrayList.add(Drivers(carNo, name, team))
        }
        cursor.close()
        db.close()
        return driversArrayList
    }

    fun deleteDriver(id:Int): Boolean {
        val db = writableDatabase
        db.delete(TABLE_NAME, "$KEY_ID = ?", arrayOf(id.toString()))
        return true

    }

    fun updateDriver(id: Int, carNo: String, name: String, team: String): Boolean {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_CAR_NO, carNo)
        contentValues.put(KEY_NAME, name)
        contentValues.put(KEY_TEAM, team)
        db.update(TABLE_NAME, contentValues, "$KEY_ID = ?", arrayOf(id.toString()))
        return true

    }
}