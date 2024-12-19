package com.singlepointsol.signinsignup

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{

        const val DATABASE_NAME = "details.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "details"
        const val KEY_NAME = "name"
        const val KEY_PASSWORD = "password"
        const val KEY_EMAIL = "email"
        const val KEY_PHONE = "phone"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME ($KEY_NAME TEXT, $KEY_PASSWORD TEXT, $KEY_EMAIL TEXT, $KEY_PHONE TEXT)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
    fun addEmployee(employee: Details):Long{
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_NAME, employee.name)
        contentValues.put(KEY_PASSWORD, employee.password)
        contentValues.put(KEY_EMAIL, employee.email)
        contentValues.put(KEY_PHONE, employee.phone)
        return db.insert(TABLE_NAME, null, contentValues)
    }
    fun getEmployee():ArrayList<Details>{
        val employeeArrayList: ArrayList<Details> = ArrayList()
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery("select * from $TABLE_NAME", null)
        while (cursor.moveToNext()) {
            val name = cursor.getString(1)
            val password = cursor.getString(2)
            val email = cursor.getString(3)
            val phone = cursor.getString(4)
            employeeArrayList.add(Details(name, password,email, phone))
        }
        cursor.close()
        db.close()
        return employeeArrayList
    }

    fun getUserByUsername(usernameInput: Any): Details? {
            val db = readableDatabase
            val cursor = db.rawQuery("SELECT * FROM users WHERE username = ?", arrayOf(usernameInput.toString()))
            var user: Details? = null
            if (cursor.moveToFirst()) {
                val username = cursor.getString(cursor.getColumnIndexOrThrow("username"))
                val password = cursor.getString(cursor.getColumnIndexOrThrow("password"))
                val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
                val phone = cursor.getString(cursor.getColumnIndexOrThrow("phone"))
                user = Details(username, password, email, phone)
            }
            cursor.close()
            return user
        }


    }


