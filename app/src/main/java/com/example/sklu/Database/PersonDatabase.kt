package com.example.sklu.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sklu.Model.Person
import com.example.sklu.Model.Plo

class PersonDatabase(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    // Creating Tables
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_CONTACTS_TABLE =
            "CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + Key_Password + " TEXT," + Key_Email + " TEXT," + KEY_NAME + " TEXT," + Key_Role + " TEXT" + ")"
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
    fun addPerson(person: Person) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME, "") // Contact Name
        values.put(Key_Role, person.role) // Contact Role
        values.put(Key_Email, person.email) // Contact Role
        values.put(Key_Password, person.password) // Contact Role

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
    }

    fun getPerson(id: String): Person {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_CONTACTS,
            arrayOf(
                KEY_ID,
                KEY_NAME,
                Key_Role,
                Key_Email,
                Key_Password,
            ),
            "$KEY_ID=? ",
            arrayOf(id),
            null,
            null,
            null,
            null
        )
        cursor?.moveToFirst()
        // return contact
        return Person(
            cursor!!.getString(0).toInt(),
            cursor.getString(1), cursor.getString(2),
            cursor.getString(3), cursor.getString(4)
        )
    }

    fun getDuplicatePerson(email: String): Person {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_CONTACTS,
            arrayOf(
                KEY_ID,
                KEY_NAME,
                Key_Role,
                Key_Email,
                Key_Password,
            ),
            "$Key_Email=? ",
            arrayOf(email),
            null,
            null,
            null,
            null
        )
        cursor?.moveToFirst()
        // return contact
        return Person(
            cursor!!.getString(0).toInt(),
            cursor.getString(1), cursor.getString(2),
            cursor.getString(3), cursor.getString(4)
        )
    }

    // code to get the single contact
    fun login(email: String, pass: String): Person {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_CONTACTS,
            arrayOf(
                KEY_ID,
                KEY_NAME,
                Key_Role,
                Key_Email,
                Key_Password,
            ),
            "$Key_Email=? AND $Key_Password=?",
            arrayOf(email, pass),
            null,
            null,
            null,
            null
        )
        cursor?.moveToFirst()
        // return contact
        return Person(
            cursor!!.getString(0).toInt(),
            cursor.getString(1), cursor.getString(2),
            cursor.getString(3), cursor.getString(4)
        )
    }// Adding contact to list

    // return contact list
// Select All Query
    val countPerson: Boolean
        get() {
            val contactList = ArrayList<Person>()
            // Select All Query
            val selectQuery = "SELECT  * FROM " + TABLE_CONTACTS
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    val person = Person()
                    person.id = cursor.getString(0).toInt()
                    person.password = cursor.getString(1)
                    person.email = cursor.getString(2)
                    person.name = cursor.getString(3)
                    person.role = cursor.getString(4)
                    // Adding contact to list
                    contactList.add(person)
                } while (cursor.moveToNext())
            }

            // return contact list
            if (contactList.size == 0) return true
            return false
        }


    fun getListContact(id: String): ArrayList<Person> {
        val contactList = ArrayList<Person>()
        // Select All Query
        val selectQuery = "SELECT  * FROM " + TABLE_CONTACTS
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                val person = Person()
                person.id = cursor.getString(0).toInt()
                person.password = cursor.getString(1)
                person.email = cursor.getString(2)
                person.name = cursor.getString(3)
                person.role = cursor.getString(4)

                if (person.id.toString() != id && !person.name.toString().startsWith("deleted")) {
                    contactList.add(person)
                }

            } while (cursor.moveToNext())
        }
        return contactList
    }

    // code to update the single contact
    fun updatePerson(name: String, id:String): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME, name)

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?", arrayOf(id))
    }


    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "ItemManager2"
        private const val TABLE_CONTACTS = "Persons"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val Key_Role = "role"
        private const val Key_Email = "email"
        private const val Key_Password = "password"
    }
}