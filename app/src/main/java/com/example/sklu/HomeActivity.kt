package com.example.sklu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.sklu.Database.CloDatabase
import com.example.sklu.Database.FavDatabase
import com.example.sklu.Model.Clo
import com.example.sklu.Model.Plo
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.backNav
import kotlinx.android.synthetic.main.fragment_fav.*


class HomeActivity : AppCompatActivity() {

    private val func = Function
    private var role: String ?= ""
    private val db = FavDatabase(this)
    private val db2 = CloDatabase(this)
    var items : ArrayList<Plo>? = null
    var clos : ArrayList<Clo>? = null
    private var home = true
    val fragmentManager = supportFragmentManager
    private var id: String=""
    private var nameText: String=""

    fun getData() {
        id = func.getPref(this, "id")
        role = func.getPref(this,"status")
        nameText = func.getPref(this, "name")
        name.text = "Hi, $nameText"
        if(role=="mhs"){
            fav.visibility = View.GONE
        }else{
            fav.visibility = View.VISIBLE
        }
        var bool = db.allPlo(id)
        if (bool!!.size == 0) {
            db.addFav(Plo("CPL-1", "false", id))
            db.addFav(Plo("CPL-2", "false", id))
            db.addFav(Plo("CPL-3", "false", id))
            db.addFav(Plo("CPL-4", "false", id))
            db.addFav(Plo("CPL-5", "false", id))
            db.addFav(Plo("CPL-6", "false", id))
            db.addFav(Plo("CPL-7", "false", id))
            db.addFav(Plo("CPL-8", "false", id))
            db.addFav(Plo("CPL-9", "false", id))
            db.addFav(Plo("CPL-10", "false", id))
            db.addFav(Plo("CPL-11", "false", id))
            db.addFav(Plo("CPL-12", "false", id))
            db.addFav(Plo("CPL-13", "false", id))
            db.addFav(Plo("CPL-14", "false", id))
            db.addFav(Plo("CPL-15", "false", id))
            db.addFav(Plo("CPL-16", "false", id))
            db.addFav(Plo("CPL-17", "false", id))
            db.addFav(Plo("CPL-18", "false", id))
            db.addFav(Plo("CPL-19", "false", id))
            db.addFav(Plo("CPL-20", "false", id))
            db.addFav(Plo("CPL-21", "false", id))
            db.addFav(Plo("CPL-22", "false", id))
            db.addFav(Plo("CPL-23", "false", id))
            db.addFav(Plo("CPL-24", "false", id))
            db.addFav(Plo("CPL-25", "false", id))
            db.addFav(Plo("CPL-26", "false", id))
            db.addFav(Plo("CPL-27", "false", id))
            db.addFav(Plo("CPL-28", "false", id))
            db.addFav(Plo("CPL-29", "false", id))
            db.addFav(Plo("CPL-30", "false", id))
            db.addFav(Plo("CPL-31", "false", id))
            db.addFav(Plo("CPL-32", "false", id))
            db.addFav(Plo("CPL-33", "false", id))
        }
        items = db.allPlo(id)

        clos = db2.allClo("all", id)
        Log.e("TAG", "getData: ${clos!!.size}" )
        if(clos!!.size == 0){
            db2.addClo(Clo("Computaion 1","0","E", "all,CPL-8,CPL-11,CPL-19,CPL-29", id))
            db2.addClo(Clo("Introduction to Algorithm","0","E", "all,CPL-8,CPL-12,CPL-14,CPL-19,CPL-29", id))
            db2.addClo(Clo("Database Systems","0","E", "all,CPL-8,CPL-14,CPL-18", id))
            db2.addClo(Clo("IT trends","0","E", "all,CPL-17,CPL-18,CPL-19,CPL-26,CPL-27", id))
            db2.addClo(Clo("Computation 2","0","E", "all,CPL-8,CPL-11,CPL-19", id))
            db2.addClo(Clo("Data Structure","0","E", "all,CPL-8,CPL-11,CPL-12,CPL-14,CPL-17CPL-19", id))
            db2.addClo(Clo("Big Data","0","E", "all,CPL-8,CPL-14,CPL-18,CPL-22,CPL-31", id))
            db2.addClo(Clo("Artificial Intelligence","0","E", "all,CPL-13,CPL-18,CPL-19,CPL-26,CPL-27,CPL-30", id))
            db2.addClo(Clo("Web Progamming","0","E", "all,CPL-8,CPL-17,CPL-18,CPL-19,CPL-24,CPL-25,CPL-27,CPL-29", id))
            db2.addClo(Clo("Distributed System","0","E", "all,CPL-8,CPL-16,CPL-24,CPL-25", id))
            db2.addClo(Clo("Computer System","0","E", "all,CPL-15,CPL-18,CPL-19,CPL-26,CPL-27", id))
            db2.addClo(Clo("Introduction to Operating Systems","0","E", "all,CPL-8,CPL-14,CPL-17,CPL-19,CPL-29", id))
            db2.addClo(Clo("Software Development","0","E", "all,CPL-8,CPL-10,CPL-14,CPL-17,CPL-18,CPL-19,CPL-22,CPL-24,CPL-26,CPL-27", id))
            db2.addClo(Clo("Mobile Programming","0","E", "all,CPL-8,CPL-14,CPL-17,CPL-18,CPL-19,CPL-24,CPL-25,CPL-27,CPL-29", id))
            db2.addClo(Clo("Humaniora","0","E", "all,CPL-1,CPL-2,CPL-3,CPL-4,CPL-5,CPL-6,CPL-7,CPL-8,CPL-20", id))
            db2.addClo(Clo("Industry Internship","0","E", "all,CPL-6,CPL-9,CPL-11,CPL-12,CPL-13,CPL-14,CPL-15,CPL-16,CPL-17,CPL-18,CPL-19,CPL-20,CPL-22,CPL-23,CPL-25,CPL-27,CPL-29,CPL-30,CPL-31,CPL-32", id))
            db2.addClo(Clo("research internship","0","E", "all,CPL-6,CPL-9,CPL-12,CPL-17,CPL-18,CPL-19,CPL-22,CPL-23,CPL-25,CPL-26,CPL-27,CPL-29,CPL-30,CPL-31,CPL-32", id))
            db2.addClo(Clo("Community internship","0","E", "all,CPL-3,CPL-4,CPL-5,CPL-6,CPL-7,CPL-17,CPL-18,CPL-19,CPL-20,CPL-22,CPL-23,CPL-25,CPL-27,CPL-29,CPL-30,CPL-31,CPL-32", id))
            db2.addClo(Clo("entrepreneurship","0","E", "all,CPL-3,CPL-4,CPL-7,CPL-8,CPL-10,CPL-17,CPL-18,CPL-19,CPL-20,CPL-22,CPL-23,CPL-24,CPL-25,CPL-27,CPL-28,CPL-29,CPL-30,CPL-31,CPL-32,CPL-33", id))
            db2.addClo(Clo("Independent Study/Project","0","E", "all,CPL-8,CPL-10,CPL-17,CPL-18,CPL-19,CPL-22,CPL-23,CPL-25,CPL-27,CPL-28", id))
            db2.addClo(Clo("Student exhange","0","E", "all,CPL-9,CPL-17,CPL-18,CPL-19,CPL-27", id))
            db2.addClo(Clo("Technopreneurship","0","E", "all,CPL-14,CPL-17,CPL-18,CPL-19,CPL-24,CPL-26,CPL-27,CPL-28,CPL-29,CPL-30,CPL-33", id))
            db2.addClo(Clo("Bachelor Thesis","0","E", "all,CPL-6,CPL-8,CPL-9,CPL-18,CPL-19,CPL-20,CPL-21,CPL-26,CPL-27,CPL-28", id))
            db2.addClo(Clo("Data Min. And Data Analytics","0","E", "all,CPL-8,CPL-13,CPL-17,CPL-18,CPL-19,CPL-22,CPL-27,CPL-31", id))
            db2.addClo(Clo("Machine Learning","0","E", "all,CPL-8,CPL-13,CPL-17,CPL-18,CPL-19,CPL-24,CPL-25,CPL-27,CPL-30,CPL-31", id))
            db2.addClo(Clo("Business process reengineering","0","E", "all,CPL-8,CPL-12,CPL-14,CPL-18,CPL-22,CPL-24,CPL-25,CPL-27,CPL-28,CPL-29", id))
            db2.addClo(Clo("Natural Language Processing","0","E", "all,CPL-8,CPL-12,CPL-17,CPL-19,CPL-22,CPL-24,CPL-25,CPL-27,CPL-29,CPL-30", id))
            db2.addClo(Clo("Artificial Neural Network","0","E", "all,CPL-8,CPL-13,CPL-18,CPL-19,CPL-26,CPL-27,CPL-29,CPL-30", id))
            db2.addClo(Clo("Computer Vision","0","E", "all,CPL-8,CPL-13,CPL-17,CPL-18,CPL-19,CPL-26,CPL-27", id))
            db2.addClo(Clo("Game Development","0","E", "all,CPL-8,CPL-29,CPL-30", id))
            db2.addClo(Clo("Game Design","0","E", "all,CPL-8,CPL-12,CPL-18,CPL-22,CPL-28,CPL-29", id))
            db2.addClo(Clo("Java Programming","0","E", "all,CPL-8,CPL-12,CPL-17,CPL-18,CPL-19,CPL-24,CPL-25,CPL-27,CPL-29", id))
            db2.addClo(Clo("Web Development","0","E", "all,CPL-8,CPL-17,CPL-18,CPL-19,CPL-24,CPL-25,CPL-27,CPL-29,CPL-30,CPL-31", id))
            db2.addClo(Clo("Social Media Analysis","0","E", "all,CPL-8,CPL-13,CPL-17,CPL-18,CPL-19,CPL-22,CPL-24,CPL-25,CPL-27,CPL-29", id))
            db2.addClo(Clo("Computer And Society","0","E", "all,CPL-3,CPL-17,CPL-18,CPL-20", id))
            db2.addClo(Clo("Teleconference Technology","0","E", "all,CPL-8,CPL-18,CPL-22,CPL-26", id))

        }


    }

    fun setButtonFunction(){
        hamburger.setOnClickListener {
            nav_bar.openDrawer(Gravity.LEFT)
        }

        backNav.setOnClickListener {
            closeDrawer()
        }
    }
    private fun closeDrawer(){
        nav_bar.closeDrawer(Gravity.LEFT, true)
    }
    fun goToHome(){
        home = true
        items = db.allPlo(id)
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentHome, HomeFragment(this, items, this))
        fragmentTransaction.commit()
        back.visibility = View.GONE
    }
    fun goToClo(type: String){
        home = false
        var tipe = "%"+type+"%"
        clos = db2.allClo(tipe, id)
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentHome, CloFragment(clos!!, this, type))
        fragmentTransaction.commit()

        closeDrawer()
        back.visibility = View.VISIBLE
    }

    override fun onBackPressed() {
        if(!home){
            goToHome()
        }else{
            super.onBackPressed();
        }
    }
    private fun logout() {
        deleteSession()
        goToLogin()
    }
    private fun deleteSession(){
        func.logout(this)
    }
    private fun goToLogin(){
        var intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finishAffinity()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getData()
        setButtonFunction()

        fav.setOnClickListener {
            home = false
            val bool = db.countPlo
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentHome, FavFragment(db.allPlo(id), bool, this))
            fragmentTransaction.commit()
            closeDrawer()

            back.visibility = View.VISIBLE
        }
        bantuan.setOnClickListener {
            home = false
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentHome, BantuanFragment(this))
            fragmentTransaction.commit()
            closeDrawer()

            back.visibility = View.VISIBLE
        }
        desc.setOnClickListener {
            home = false
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentHome, DescFragment(this))
            fragmentTransaction.commit()
            closeDrawer()

            back.visibility = View.VISIBLE
        }
        logout.setOnClickListener {
            logout()
        }


        goToHome()

        back.setOnClickListener {
            goToHome()
        }
//        val llm = LinearLayoutManager(this)
//        llm.orientation = LinearLayoutManager.VERTICAL
//        val itemAdapter = CloAdapter(this, items)
//        recycler.setLayoutManager(llm)
//        recycler.adapter = itemAdapter

    }

}