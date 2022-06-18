package com.example.sklu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_after_login.*

class AfterLogin : AppCompatActivity() {
    private fun validate(): Boolean{
        if(username.text.isEmpty()){
            return false
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_login)

        submit.setOnClickListener {
            if(!validate()){
                Toast.makeText(this, "Input UserName First", Toast.LENGTH_SHORT).show()
            }
            else{
                Function.setPref(this, username.text.toString())
                var intent = Intent(this@AfterLogin, HomeActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            }
        }
    }
}