package com.example.sklu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.sklu.Database.PersonDatabase
import com.example.sklu.Model.Person
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.register

class RegisterActivity : AppCompatActivity() {
    private val dbPerson = PersonDatabase(this)
    private val func = Function
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
        if(email.text.isEmpty() || pass.text.isEmpty() || pass2.text.isEmpty()){
            registerMhs.isEnabled = false
            registerCmp.isEnabled = false
            admin.isEnabled = false
        }else{
            registerMhs.isEnabled = true
            registerCmp.isEnabled = true
            admin.isEnabled= true
        }
    }

    private fun showResponse(x:String){
        Toast.makeText(this, x, Toast.LENGTH_SHORT).show()
    }
    fun getDuplicate(email: String):Boolean{
        var person: Person?=null
        try {
            person = dbPerson.getDuplicatePerson(email)
        }catch (e: Exception){
            person = null
        }
        if(person!=null)return true
        return false
    }

    private fun inputValidation(person: Person, pass2: String):String{
        if(email.text.isEmpty() || pass.text.isEmpty() || pass2 == ""){
            return "Please Fill All Field"
        }

        if(!func.emailValidation(person.email!!)){
            return "Format email harus benar"
        }

        else if(person.password!!.length<6){
            return "Password harus lebih dari 5 huruf"
        }
        else if(person.password!! != pass2){
            return "Password harus sama dengan password konfirmasi"
        }
        if(getDuplicate(email.text.toString())){
            return "Email ini sudah digunakan, coba pakai email yang lain"
        }
        return ""
    }

    private fun regis(person: Person){

        dbPerson.addPerson(person)

        goToLogin()

    }
    private fun goToLogin(){
        var i = Intent(this, MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(i)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        register.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
        registerMhs.setOnClickListener {
            val person = Person(email.text.toString(), pass.text.toString())
            val response = inputValidation(person, pass2.text.toString())
            if(response!=""){
                showResponse(response)
            }
            else {
                role = "mhs"

                val person = Person("", role, email.text.toString(), pass.text.toString() )
                regis(person)
            }

//            intent = Intent(this, HomeActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//            startActivity(intent)
//            finishAffinity()
        }

        registerCmp.setOnClickListener {
            val person = Person(email.text.toString(), pass.text.toString())
            val response = inputValidation(person, pass2.text.toString())
            if(response!=""){
                showResponse(response)
            }
            else {
                role = "cmp"

                val person = Person("", role, email.text.toString(), pass.text.toString() )
                regis(person)
            }

//            intent = Intent(this, HomeActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//            startActivity(intent)
//            finishAffinity()
        }

        admin.setOnClickListener {
            val person = Person(email.text.toString(), pass.text.toString())
            val response = inputValidation(person, pass2.text.toString())
            if(response!=""){
                showResponse(response)
            }
            else {
                role = "admin"

                val person = Person("", role, email.text.toString(), pass.text.toString() )
                regis(person)
            }

//            intent = Intent(this, HomeActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//            startActivity(intent)
//            finishAffinity()
        }
    }
}