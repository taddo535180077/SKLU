package com.example.sklu

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.sklu.Model.Person

class Function {
    companion object{
        private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"


        fun emailValidation(email: String): Boolean{
            return email.matches(this.emailPattern.toRegex())
        }

        fun login(mContext: Context, person: Person){
            val editor = mContext.getSharedPreferences("PREFS", AppCompatActivity.MODE_PRIVATE).edit()
            editor.putString("role", person.email)
            editor.putString("id", person.id.toString())
            editor.putString("name", person.name)
            editor.putString("pass", person.password)
            editor.putString("status", person.role)
            editor.apply()
        }
        fun logout(mContext: Context){
            val editor = mContext.getSharedPreferences("PREFS", AppCompatActivity.MODE_PRIVATE).edit()
            editor.putString("role", "none")
            editor.putString("id", "none")
            editor.putString("name", "none")
            editor.putString("pass", "none")
            editor.putString("status", "none")
            editor.apply()
        }

        fun getPref(mContext: Context, type: String):String{
            var preference = mContext.getSharedPreferences("PREFS", AppCompatActivity.MODE_PRIVATE)
            if(type=="email") return preference.getString("role", "none").toString()
            else if (type=="name") return preference.getString("name", "none").toString()
            else if (type=="countTrans") return preference.getString("countTrans", "1").toString()
            else if (type=="id") return preference.getString("id", "none").toString()
            else if (type=="status") return preference.getString("status", "none").toString()
            else if (type=="pass") return preference.getString("pass", "none").toString()

            return ""
        }

    }
}