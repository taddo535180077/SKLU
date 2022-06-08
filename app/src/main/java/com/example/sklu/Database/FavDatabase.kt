package com.example.sklu.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sklu.Model.Clo
import com.example.sklu.Model.Plo

class FavDatabase(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    // Creating Tables
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_CONTACTS_TABLE =
            "CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + Key_NAME + " TEXT," +  KEY_FAV + " TEXT," + KEY_PERSON_ID + " TEXT" +")"
        db.execSQL(CREATE_CONTACTS_TABLE)
    }

    // Upgrading database
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS)

        // Create tables again
        onCreate(db)
    }


    // code to add the new contact
    fun addFav(plo: Plo) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(Key_NAME, plo.name) // CLO NAME
        values.put(KEY_FAV, plo.fav) // CLO NAME
        values.put(KEY_PERSON_ID, plo.idPerson)
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
    }

    // return contact list

    fun allPlo(id: String): ArrayList<Plo>? {
        val db = this.readableDatabase
        val contactList: MutableList<Plo> = ArrayList()

        val cursor = db.query(
            FavDatabase.TABLE_CONTACTS, arrayOf(
                FavDatabase.KEY_ID,
                FavDatabase.Key_NAME,
                FavDatabase.KEY_FAV,
                FavDatabase.KEY_PERSON_ID
            ), FavDatabase.KEY_PERSON_ID + " = ?", arrayOf(id), FavDatabase.KEY_ID, null, null, null
        )
        if (cursor.moveToFirst()) {
            do {
                val contact = Plo()
                    contact.id = cursor.getString(0).toInt()
                    contact.name = cursor.getString(1)
                    contact.fav = cursor.getString(2)
                    contact.idPerson = cursor.getString(3)
                // Adding contact to list
                contactList.add(contact)
            } while (cursor.moveToNext())
        }

        return contactList as ArrayList<Plo>
        // return contact
    }

// Select All Query
    val countPlo: Boolean
        get() {
            val contactList: MutableList<Plo> = ArrayList()
            // Select All Query
            val selectQuery = "SELECT  * FROM " + TABLE_CONTACTS
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    val contact = Plo()
                    contact.id = cursor.getString(0).toInt()
                    contact.name = cursor.getString(1)
                    // Adding contact to list
                    contactList.add(contact)
                } while (cursor.moveToNext())
            }

            // return contact list
            if(contactList.isNotEmpty()) return true
            return false
        }

    // looping through all rows and adding to list
    // code to get all contacts in a list view
//    val allPlo: ArrayList<Plo>
//        get() {
//            val contactList: MutableList<Plo> = ArrayList()
//            // Select All Query
//            val selectQuery = "SELECT  * FROM " + TABLE_CONTACTS
//            val db = this.writableDatabase
//            val cursor = db.rawQuery(selectQuery, null)
//
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    val contact = Plo()
//                    contact.id = cursor.getString(0).toInt()
//                    contact.name = cursor.getString(1)
//                    contact.fav = cursor.getString(2)
//                    contact.idPerson = cursor.getString(3)
//                    // Adding contact to list
//                    contactList.add(contact)
//                } while (cursor.moveToNext())
//            }
//
//            // return contact list
//            return contactList as ArrayList<Plo>
//        }

    // code to update the single contact
    fun updateFav(id: Int, status: String?): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_FAV, status)

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?", arrayOf(id.toString()))
    }

    fun deleteAllCart() {
        val db = this.writableDatabase
        db.delete(TABLE_CONTACTS, null, null)
        db.close()
    }// return count

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "FavDatabase"
        private const val TABLE_CONTACTS = "Plo"
        private const val KEY_ID = "id"
        private const val Key_NAME = "name"
        private const val KEY_FAV = "fav"
        private const val KEY_PERSON_ID = "idperson"
    }
}