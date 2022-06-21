package com.example.sklu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sklu.Database.CloDatabase
import com.example.sklu.Model.Clo
import kotlinx.android.synthetic.main.activity_after_login.*
import kotlinx.android.synthetic.main.activity_input_mhs.*
import kotlinx.android.synthetic.main.activity_input_mhs.submit
import kotlinx.android.synthetic.main.activity_input_mhs.username

class InputMhs : AppCompatActivity() {
    private val db2 = CloDatabase(this)
    private val func = Function

    private fun validate(): Boolean {
        if (username.text.isEmpty()) {
            return false
        }

        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_mhs)

        submit.setOnClickListener {


            if (!validate()) {
                Toast.makeText(this, "Input UserName First", Toast.LENGTH_SHORT).show()
            } else {

                val id = func.getPref(this, "idCmp")
                val namePerson = username.text.toString()
                Function.setPref(this, namePerson, "username")
                var clos = db2.allClo("%all%", id, namePerson)
                if(clos!!.size==0) {
                    db2.addClo(
                        Clo(
                            "Computation 1",
                            "0",
                            "E",
                            "all,CPL-8,CPL-11,CPL-19,CPL-29,",
                            id,
                            namePerson
                        )
                    )
                    db2.addClo(
                        Clo(
                            "Introduction to Algorithm",
                            "0",
                            "E",
                            "all,CPL-8,CPL-12,CPL-14,CPL-19,CPL-29,",
                            id, namePerson
                        )
                    )
                    db2.addClo(
                        Clo(
                            "Database Systems",
                            "0",
                            "E",
                            "all,CPL-8,CPL-14,CPL-18,",
                            id,
                            namePerson
                        )
                    )
                    db2.addClo(
                        Clo(
                            "IT trends",
                            "0",
                            "E",
                            "all,CPL-17,CPL-18,CPL-19,CPL-26,CPL-27,",
                            id,
                            namePerson
                        )
                    )
                    db2.addClo(
                        Clo(
                            "Computation 2",
                            "0",
                            "E",
                            "all,CPL-8,CPL-11,CPL-19,",
                            id,
                            namePerson
                        )
                    )
                    db2.addClo(
                        Clo(
                            "Data Structure",
                            "0",
                            "E",
                            "all,CPL-8,CPL-11,CPL-12,CPL-14,CPL-17CPL-19,",
                            id, namePerson
                        )
                    )
                    db2.addClo(
                        Clo(
                            "Big Data",
                            "0",
                            "E",
                            "all,CPL-8,CPL-14,CPL-18,CPL-22,CPL-31,",
                            id,
                            namePerson
                        )
                    )
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
                    db2.addClo(
                        Clo(
                            "Distributed System",
                            "0",
                            "E",
                            "all,CPL-8,CPL-16,CPL-24,CPL-25,",
                            id,
                            namePerson
                        )
                    )
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
                    db2.addClo(
                        Clo(
                            "Game Development",
                            "0",
                            "E",
                            "all,CPL-8,CPL-29,CPL-30,",
                            id,
                            namePerson
                        )
                    )
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
                    db2.addClo(
                        Clo(
                            "Computer And Society",
                            "0",
                            "E",
                            "all,CPL-3,CPL-17,CPL-20,",
                            id,
                            namePerson
                        )
                    )
                }
                var intent = Intent(this@InputMhs, HomeActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            }
        }
    }
}