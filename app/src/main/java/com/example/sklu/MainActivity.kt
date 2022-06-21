package com.example.sklu

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.example.sklu.Database.PersonDatabase
import com.example.sklu.Model.Person
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.email
import kotlinx.android.synthetic.main.activity_main.pass
import kotlinx.android.synthetic.main.activity_main.register
import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {
    private val func = Function
    private var dbPerson = PersonDatabase(this)
    private var role = ""
    private val mTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            checkFieldsForEmptyValues()
        }

        override fun afterTextChanged(editable: Editable) {
            // check Fields For Empty Values

        }
    }

    private fun checkFieldsForEmptyValues(){
        if(email.text.isEmpty() || pass.text.toString().isEmpty()){
            login.isEnabled = false
//            login.setBackgroundResource(R.drawable.main_button_off)
        }else{
            login.isEnabled = true
//            login.setBackgroundResource(R.drawable.main_button)
        }
    }

    private fun loginValidation(email: String, pass:String):String{
        if(email == "" || pass == "" ){
            return "Please Fill Email and Password"
        }
        if(!func.emailValidation(email)){
            return "Format email harus benar"
        }else if(pass.length<6){
            return "Password harus lebih dari 5 huruf"
        }
        var person: Person? = null

        try {
            person = dbPerson.login(email, pass)
        }catch (e: Exception){
            e.printStackTrace()
        }
        if(person==null){
            return "Email atau Password salah!"
        }
        return ""
    }
    private fun login() {
        var person: Person? = null

        try {
            person = dbPerson.login(email.text.toString(), pass.text.toString())
        }catch (e: Exception){
            e.printStackTrace()
        }
        setData(person!!)

    }
    private fun setData(person: Person){
        func.login(this, person)

        goToMain()
    }
    private fun goToMain(){
        val name = func.getPref(this, "name")

        if(name!="") {
            var intent = Intent(this@MainActivity, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }else{
            var intent = Intent(this@MainActivity, AfterLogin::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }

    private fun isLogin(){
        role = func.getPref(this, "email")
        if (role != "none") {
            goToMain()
        }
    }

    private fun showResponse(x:String) {
        Toast.makeText(this, x, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        register.paintFlags = register.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        login.setOnClickListener {
            val response = loginValidation(email.text.toString(), pass.text.toString())
            if(response!="") showResponse(response)
            else login()
        }
        isLogin()

        register.setOnClickListener {
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}