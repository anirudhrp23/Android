package com.singlepointsol.databasedemo

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class EmpDBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_NAME = "employee.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "emp_table"
        const val KEY_ID = "_Id"
        const val KEY_NAME = "Name"
        const val KEY_EMAIL = "Email"
        const val KEY_PHONE = "Phone"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "create table $TABLE_NAME($KEY_ID integer primary key autoincrement, $KEY_NAME text, $KEY_EMAIL text, $KEY_PHONE text)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)  {
        db?.execSQL("drop table if exists $TABLE_NAME")
        onCreate(db)
    }
    fun addEmployee(employee: Employee):Long{
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_NAME, employee.name)
        contentValues.put(KEY_EMAIL, employee.email)
        contentValues.put(KEY_PHONE, employee.phone)
        return db.insert(TABLE_NAME, null, contentValues)
    }
    fun getEmployee():ArrayList<Employee>{
        val employeeArrayList: ArrayList<Employee> = ArrayList()
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery("select * from $TABLE_NAME", null)
        while (cursor.moveToNext()) {
            val name = cursor.getString(1)
            val email = cursor.getString(2)
            val phone = cursor.getString(3)
            employeeArrayList.add(Employee(name, email, phone))
        }
        cursor.close()
        db.close()
            return employeeArrayList
    }
    fun updateEmployee(id:String,name:String,email:String,phone:String): Boolean {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, id)
        contentValues.put(KEY_NAME, name)
        contentValues.put(KEY_EMAIL, email)
        contentValues.put(KEY_PHONE, phone)
        db.update(TABLE_NAME, contentValues, "$KEY_ID=?", arrayOf(id))

        return true
    }
    fun deleteEmployee(id:String):Int{
        val db = writableDatabase
        return db.delete(TABLE_NAME, "$KEY_ID=?", arrayOf(id))
    }
}
