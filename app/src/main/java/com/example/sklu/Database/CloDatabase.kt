package com.example.sklu.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sklu.Model.Clo

class CloDatabase(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    // Creating Tables
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_CONTACTS_TABLE =
            "CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + Key_NAME + " TEXT," + KEY_SCORE + " TEXT," + KEY_GRADE + " TEXT," + KEY_STATUS + " TEXT," + KEY_LIST + " TEXT," + KEY_ID_PERSON + " TEXT," + KEY_NAME_PERSON + " TEXT"+")"
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
    fun addClo(clo: Clo) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(Key_NAME, clo.name) // CLO NAME
        values.put(KEY_STATUS, clo.status) // CLO NAME
        values.put(KEY_SCORE, clo.score)//
        values.put(KEY_GRADE, clo.grade)//
        values.put(KEY_LIST, clo.list)//
        values.put(KEY_ID_PERSON, clo.idPerson)//
        values.put(KEY_NAME_PERSON, clo.username)//
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
    }

    // code to get the single contact
    fun allClo(type: String, id:String,username: String): ArrayList<Clo>? {
        val db = this.readableDatabase
        val contactList: MutableList<Clo> = ArrayList()

        val cursor = db.query(
            TABLE_CONTACTS, arrayOf(
                KEY_ID, Key_NAME, KEY_SCORE, KEY_GRADE
            ), KEY_LIST + " LIKE ? AND "+ KEY_ID_PERSON+" = ? AND "+ KEY_NAME_PERSON+ " = ?",
            arrayOf(type, id, username), KEY_ID, null, null, null
        )
        if (cursor.moveToFirst()) {
            do {
                val contact = Clo()
                contact.id = cursor.getString(0).toInt()
                contact.name = cursor.getString(1)
                contact.score = cursor.getString(2)
                contact.grade = cursor.getString(3)
                // Adding contact to list
                contactList.add(contact)
            } while (cursor.moveToNext())
        }

        return contactList as ArrayList<Clo>
        // return contact
    }// Adding contact to list

    fun getClo(type: String, id:String,username: String): Clo {
        val db = this.readableDatabase
        val contactList: MutableList<Clo> = ArrayList()

        val cursor = db.query(
            TABLE_CONTACTS, arrayOf(
                KEY_ID, Key_NAME, KEY_SCORE, KEY_GRADE
            ), Key_NAME + " = ? AND "+ KEY_ID_PERSON+" = ? AND "+ KEY_NAME_PERSON + " = ?", arrayOf(type, id,username), KEY_ID, null, null, null
        )
        if (cursor.moveToFirst()) {
            do {
                val contact = Clo()
                contact.id = cursor.getString(0).toInt()
                contact.name = cursor.getString(1)
                contact.score = cursor.getString(2)
                contact.grade = cursor.getString(3)
                // Adding contact to list
                contactList.add(contact)
            } while (cursor.moveToNext())
            return contactList[0]
        }

        return Clo()
        // return contact
    }// Adding contact to list

    fun getCloResult(id:String): ArrayList<Clo>? {
        val db = this.readableDatabase
        val contactList: MutableList<Clo> = ArrayList()

        val cursor = db.query(
            TABLE_CONTACTS, arrayOf(
                KEY_ID, Key_NAME, KEY_SCORE, KEY_GRADE, KEY_NAME_PERSON
            ), KEY_ID_PERSON+ " = ?",
            arrayOf(id), KEY_NAME_PERSON ,null, null, null
        )
        if (cursor.moveToFirst()) {
            do {
                val contact = Clo()
                contact.id = cursor.getString(0).toInt()
                contact.name = cursor.getString(1)
                contact.score = cursor.getString(2)
                contact.grade = cursor.getString(3)
                contact.username = cursor.getString(4)
                // Adding contact to list
                contactList.add(contact)
            } while (cursor.moveToNext())
        }

        return contactList as ArrayList<Clo>
        // return contact
    }// Adding contact to list


    // return contact list
// Select All Query
    val countClo: Boolean
        get() {
            val contactList: MutableList<Clo> = ArrayList()
            // Select All Query
            val selectQuery = "SELECT  * FROM " + TABLE_CONTACTS
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    val contact = Clo()
                    contact.id = cursor.getString(0).toInt()
                    contact.name = cursor.getString(1)
                    contact.score = cursor.getString(2)
                    contact.grade = cursor.getString(3)
                    contact.status = cursor.getString(4)
                    contact.list = cursor.getString(5)
                    contact.idPerson = cursor.getString(6)
                    contact.username = cursor.getString(7)
                    // Adding contact to list
                    contactList.add(contact)
                } while (cursor.moveToNext())
            }

            // return contact list
            if (contactList.isNotEmpty()) return true
            return false
        }

    // looping through all rows and adding to list
    // code to get all contacts in a list view
//    val allClo  : ArrayList<Clo>
//        get() {
//            val contactList: MutableList<Clo> = ArrayList()
//            // Select All Query
//            val selectQuery = "SELECT  * FROM " + TABLE_CONTACTS
//            val db = this.writableDatabase
//            val cursor = db.rawQuery(selectQuery, null)
//
//            // looping through all rows and adding to list
//            if (cursor.moveToFirst()) {
//                do {
//                    val contact = Clo()
//                    contact.id = cursor.getString(0).toInt()
//                    contact.name = cursor.getString(1)
//                    contact.score = cursor.getString(2)
//                    contact.grade = cursor.getString(3)
//                    contact.status = cursor.getString(4)
//                    contact.list = cursor.getString(5)
//                    // Adding contact to list
//                    contactList.add(contact)
//                } while (cursor.moveToNext())
//            }
//
//            // return contact list
//            return contactList as ArrayList<Clo>
//        }

    // code to update the single contact
    fun updateClo(id: Int, score: String?, status: String?, grade: String?, username: String): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_SCORE, score)
        values.put(KEY_STATUS, status)
        values.put(KEY_GRADE, grade)
        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ? AND "+ KEY_NAME_PERSON +" = ?",
            arrayOf(id.toString(), username))
    }


    fun deleteAllCart() {
        val db = this.writableDatabase
        db.delete(TABLE_CONTACTS, null, null)
        db.close()
    }// return count

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "CloDatabase"
        private const val TABLE_CONTACTS = "Clo"
        private const val KEY_ID = "id"
        private const val Key_NAME = "name"
        private const val KEY_STATUS = "status"
        private const val KEY_SCORE = "nilai"
        private const val KEY_GRADE = "grade"
        private const val KEY_LIST = "list"
        private const val KEY_ID_PERSON = "idperson"
        private const val KEY_NAME_PERSON = "nameperson"
    }
}