package com.example.sklu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
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
    private var role: String? = ""
    private val db = FavDatabase(this)
    private val db2 = CloDatabase(this)
    var items: ArrayList<Plo>? = null
    var clos: ArrayList<Clo>? = null
    private var home = true
    val fragmentManager = supportFragmentManager
    private var id: String = ""
    private var nameText: String = ""
    private var favBtn = false
    private var namePerson = ""


    fun getData() {
        id = func.getPref(this, "id")

        namePerson = func.getPref(this, "name")
        nameText = func.getPref(this, "username")
        name.text = "Hi, $namePerson"
        if (role == "mhs") {
            fav.visibility = View.GONE
        } else {
            fav.visibility = View.VISIBLE
        }
        if (role != "admin") {
            hasil.visibility = View.GONE
        } else {
            hasil.visibility = View.VISIBLE
        }
        var bool = db.allPlo("admin")
        if (bool!!.size == 0) {
            db.addFav(Plo("CPL-1", "false", "admin"))
            db.addFav(Plo("CPL-2", "false", "admin"))
            db.addFav(Plo("CPL-3", "false", "admin"))
            db.addFav(Plo("CPL-4", "false", "admin"))
            db.addFav(Plo("CPL-5", "false", "admin"))
            db.addFav(Plo("CPL-6", "false", "admin"))
            db.addFav(Plo("CPL-7", "false", "admin"))
            db.addFav(Plo("CPL-8", "false", "admin"))
            db.addFav(Plo("CPL-9", "false", "admin"))
            db.addFav(Plo("CPL-10", "false", "admin"))
            db.addFav(Plo("CPL-11", "false", "admin"))
            db.addFav(Plo("CPL-12", "false", "admin"))
            db.addFav(Plo("CPL-13", "false", "admin"))
            db.addFav(Plo("CPL-14", "false", "admin"))
            db.addFav(Plo("CPL-15", "false", "admin"))
            db.addFav(Plo("CPL-16", "false", "admin"))
            db.addFav(Plo("CPL-17", "false", "admin"))
            db.addFav(Plo("CPL-18", "false", "admin"))
            db.addFav(Plo("CPL-19", "false", "admin"))
            db.addFav(Plo("CPL-20", "false", "admin"))
            db.addFav(Plo("CPL-21", "false", "admin"))
            db.addFav(Plo("CPL-22", "false", "admin"))
            db.addFav(Plo("CPL-23", "false", "admin"))
            db.addFav(Plo("CPL-24", "false", "admin"))
            db.addFav(Plo("CPL-25", "false", "admin"))
            db.addFav(Plo("CPL-26", "false", "admin"))
            db.addFav(Plo("CPL-27", "false", "admin"))
            db.addFav(Plo("CPL-28", "false", "admin"))
            db.addFav(Plo("CPL-29", "false", "admin"))
            db.addFav(Plo("CPL-30", "false", "admin"))
            db.addFav(Plo("CPL-31", "false", "admin"))
            db.addFav(Plo("CPL-32", "false", "admin"))
            db.addFav(Plo("CPL-33", "false", "admin"))
        }
        items = db.allPlo("admin")

        clos = db2.allClo("%all%", id, namePerson)
        if (clos!!.size == 0 && role != "cmp") {
            db2.addClo(Clo("Computation 1", "0", "E", "all,CPL-8,CPL-11,CPL-19,CPL-29,", id,namePerson))
            db2.addClo(
                Clo(
                    "Introduction to Algorithm",
                    "0",
                    "E",
                    "all,CPL-8,CPL-12,CPL-14,CPL-19,CPL-29,",
                    id, namePerson
                )
            )
            db2.addClo(Clo("Database Systems", "0", "E", "all,CPL-8,CPL-14,CPL-18,", id, namePerson))
            db2.addClo(Clo("IT trends", "0", "E", "all,CPL-17,CPL-18,CPL-19,CPL-26,CPL-27,", id, namePerson))
            db2.addClo(Clo("Computation 2", "0", "E", "all,CPL-8,CPL-11,CPL-19,", id, namePerson))
            db2.addClo(
                Clo(
                    "Data Structure",
                    "0",
                    "E",
                    "all,CPL-8,CPL-11,CPL-12,CPL-14,CPL-17CPL-19,",
                    id, namePerson
                )
            )
            db2.addClo(Clo("Big Data", "0", "E", "all,CPL-8,CPL-14,CPL-18,CPL-22,CPL-31,", id, namePerson))
            db2.addClo(
                Clo(
                    "Artificial Intelligence",
                    "0",
                    "E",
                    "all,CPL-13,CPL-18,CPL-19,CPL-26,CPL-27,CPL-30,",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Web Progamming",
                    "0",
                    "E",
                    "all,CPL-8,CPL-17,CPL-18,CPL-19,CPL-24,CPL-25,CPL-27,CPL-29,",
                    id, namePerson
                )
            )
            db2.addClo(Clo("Distributed System", "0", "E", "all,CPL-8,CPL-16,CPL-24,CPL-25,", id, namePerson))
            db2.addClo(
                Clo(
                    "Computer System",
                    "0",
                    "E",
                    "all,CPL-15,CPL-18,CPL-19,CPL-26,CPL-27,",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Introduction to Operating Systems",
                    "0",
                    "E",
                    "all,CPL-8,CPL-14,CPL-17,CPL-19,CPL-29,",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Software Development",
                    "0",
                    "E",
                    "all,CPL-8,CPL-10,CPL-14,CPL-17,CPL-18,CPL-19,CPL-22,CPL-24,CPL-26,CPL-27,",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Mobile Programming",
                    "0",
                    "E",
                    "all,CPL-8,CPL-14,CPL-17,CPL-18,CPL-19,CPL-24,CPL-25,CPL-27,CPL-29,",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Humaniora",
                    "0",
                    "E",
                    "all,CPL-1,CPL-2,CPL-3,CPL-4,CPL-5,CPL-6,CPL-7,CPL-8,CPL-20,",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Industry Internship",
                    "0",
                    "E",
                    "all,CPL-3,CPL-4,CPL-5,CPL-6,CPL-7,CPL-8,CPL-9,CPL-10,CPL-11,CPL-12,CPL-13,CPL-14,CPL-15,CPL-16,CPL-18,CPL-19,CPL-20,CPL-22,CPL-23,CPL-24,CPL-25,CPL-26,CPL-27,CPL-28,CPL-29,CPL-30,CPL-31,CPL-32,CPL-33",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Technopreneurship",
                    "0",
                    "E",
                    "all,CPL-14,CPL-17,CPL-18,CPL-19,CPL-24,CPL-26,CPL-27,CPL-28,CPL-29,CPL-30,CPL-33,",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Bachelor Thesis",
                    "0",
                    "E",
                    "all,CPL-6,CPL-8,CPL-9,CPL-18,CPL-19,CPL-20,CPL-21,CPL-26,CPL-27,CPL-28,",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Data Min. And Data Analytics",
                    "0",
                    "E",
                    "all,CPL-8,CPL-13,CPL-17,CPL-18,CPL-19,CPL-22,CPL-27,CPL-31,",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Machine Learning",
                    "0",
                    "E",
                    "all,CPL-8,CPL-13,CPL-17,CPL-18,CPL-19,CPL-24,CPL-25,CPL-27,CPL-30,CPL-31,",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Business process reengineering",
                    "0",
                    "E",
                    "all,CPL-8,CPL-12,CPL-14,CPL-18,CPL-22,CPL-24,CPL-25,CPL-27,CPL-28,CPL-29,",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Natural Language Processing",
                    "0",
                    "E",
                    "all,CPL-8,CPL-12,CPL-17,CPL-19,CPL-22,CPL-24,CPL-25,CPL-27,CPL-29,CPL-30,",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Artificial Neural Network",
                    "0",
                    "E",
                    "all,CPL-8,CPL-13,CPL-18,CPL-19,CPL-26,CPL-27,CPL-29,CPL-30,",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Computer Vision",
                    "0",
                    "E",
                    "all,CPL-8,CPL-13,CPL-17,CPL-18,CPL-19,CPL-26,CPL-27,",
                    id, namePerson
                )
            )
            db2.addClo(Clo("Game Development", "0", "E", "all,CPL-8,CPL-29,CPL-30,", id, namePerson))
            db2.addClo(
                Clo(
                    "Game Design",
                    "0",
                    "E",
                    "all,CPL-8,CPL-12,CPL-18,CPL-22,CPL-28,CPL-29,",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Java Programming",
                    "0",
                    "E",
                    "all,CPL-8,CPL-12,CPL-17,CPL-18,CPL-19,CPL-24,CPL-25,CPL-27,CPL-29,",
                    id, namePerson
                )
            )
            db2.addClo(
                Clo(
                    "Web Development",
                    "0",
                    "E",
                    "all,CPL-8,CPL-17,CPL-18,CPL-19,CPL-24,CPL-25,CPL-27,CPL-29,CPL-30,CPL-31,",
                    id, namePerson
                )
            )
            db2.addClo(Clo("Computer And Society", "0", "E", "all,CPL-3,CPL-17,CPL-20,", id, namePerson))

        }


    }

    fun setButtonFunction() {
        hamburger.setOnClickListener {
            nav_bar.openDrawer(Gravity.LEFT)
        }

        backNav.setOnClickListener {
            closeDrawer()
        }
    }

    private fun closeDrawer() {
        nav_bar.closeDrawer(Gravity.LEFT, true)
    }

    fun goToHome() {
        favBtn = false
        home = true
        if (role == "cmp") {
            goToFav()
        } else {
            items = db.allPlo("admin")

            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentHome, HomeFragment(this, items, this))
            fragmentTransaction.commit()
            back.visibility = View.GONE
        }
    }

    private fun goToFav() {
        if (role == "cmp") {
            home = true
            back.visibility = View.GONE
            fav.visibility = View.GONE
        } else {
            home = false
            back.visibility = View.VISIBLE
        }
        val bool = db.countPlo
        val fragmentTransaction = fragmentManager.beginTransaction()
        items = db.allPlo("admin")
        fragmentTransaction.replace(R.id.fragmentHome, FavFragment(items, bool, this))
        fragmentTransaction.commit()
        closeDrawer()


    }

    fun goToClo(type: String) {
        home = false
        var tipe = "%," + type + ",%"
        var username = ""
        if(role == "cmp") username = func.getPref(this, "username")
        else username = func.getPref(this, "name")
        func.setPref(this, username, "username")
        clos = db2.allClo(tipe, id, username)
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentHome, CloFragment(clos!!, this, type))
        fragmentTransaction.commit()

        closeDrawer()
        back.visibility = View.VISIBLE
    }

    override fun onBackPressed() {
        if (favBtn) {
            goToFav()
            favBtn = false
        } else if (!home) {
            favBtn = false
            goToHome()
        } else {
            favBtn = false
            super.onBackPressed();
        }
    }

    private fun logout() {
        deleteSession()
        goToLogin()
    }

    private fun deleteSession() {
        func.logout(this)
    }

    private fun goToLogin() {
        var intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finishAffinity()
    }

    fun SetFav(from: String) {
        if(from=="fav")favBtn = !favBtn
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var id = Function.getPref(this, "id")

        val username = func.getPref(this, "username")
        role = func.getPref(this, "status")

        Log.e("ERROR===", "onCreate: asd$username asd$role", )
        if(username == "none" && role=="cmp"){
            var intent = Intent(this@HomeActivity, InputMhs::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

        getData()
        setButtonFunction()

        fav.setOnClickListener {
            goToFav()
        }
        hasil.setOnClickListener {
            home = false
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentHome, HasilFragment(this))
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

        pengukuran.setOnClickListener {
            home = true
            goToHome()
            closeDrawer()

            back.visibility = View.GONE
        }

        logout.setOnClickListener {
            logout()
        }


        goToHome()

        back.setOnClickListener {
            this.onBackPressed()
//            goToHome()
        }
//        val llm = LinearLayoutManager(this)
//        llm.orientation = LinearLayoutManager.VERTICAL
//        val itemAdapter = CloAdapter(this, items)
//        recycler.setLayoutManager(llm)
//        recycler.adapter = itemAdapter

    }

}