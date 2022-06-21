package com.example.sklu

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.sklu.Database.CloDatabase
import com.example.sklu.Model.Plo
import java.io.Serializable
import kotlin.math.log

class Decision(val mContext: Context) {

    private var db = CloDatabase(mContext)
    private val idPerson = Function.getPref(mContext, "id")
    private val idCmp = Function.getPref(mContext, "idCmp")
    private var username = ""

    fun getPlo(type: String, username: String): String {
        this.username = username
        when (type) {
            "CPL-1" -> return cpl1()
            "CPL-2" -> return cpl2()
            "CPL-3" -> return cpl3()
            "CPL-4" -> return cpl4()
            "CPL-5" -> return cpl5()
            "CPL-6" -> return cpl6()
            "CPL-7" -> return cpl7()
            "CPL-8" -> return cpl8()
            "CPL-9" -> return cpl9()
            "CPL-10" -> return cpl10()
            "CPL-11" -> return cpl11()
            "CPL-12" -> return cpl12()
            "CPL-13" -> return cpl13()
            "CPL-14" -> return cpl14()
            "CPL-15" -> return cpl15()
            "CPL-16" -> return cpl16()
            "CPL-17" -> return cpl17()
            "CPL-18" -> return cpl18()
            "CPL-19" -> return cpl19()
            "CPL-20" -> return cpl20()
            "CPL-21" -> return cpl21()
            "CPL-22" -> return cpl22()
            "CPL-23" -> return cpl23()
            "CPL-24" -> return cpl24()
            "CPL-25" -> return cpl25()
            "CPL-26" -> return cpl26()
            "CPL-27" -> return cpl27()
            "CPL-28" -> return cpl28()
            "CPL-29" -> return cpl29()
            "CPL-30" -> return cpl30()
            "CPL-31" -> return cpl31()
            "CPL-32" -> return cpl32()
            "CPL-33" -> return cpl33()
            else -> return ""
        }

    }

    private fun cpl1(): String {
        val humanoria = arrayOf("A", "A", "NA", "Humaniora")
        return decition(idPerson, humanoria as Array<Serializable>)
    }

    private fun cpl2(): String {
        val humanoria = arrayOf("A", "A", "NA", "Humaniora")

        return decition(idPerson, humanoria as Array<Serializable>)
    }

    private fun cpl3(): String {
        val industri = arrayOf("A", "NA", "NA", "Industry Internship")
        val comp = arrayOf("A", industri, "NA", "Computer And Society")
        val humanoria = arrayOf("A", "A", comp, "Humaniora")

        return decition(idPerson, humanoria as Array<Serializable>)
    }

    private fun cpl4(): String {
        val industri = arrayOf("A", "NA", "NA", "Industry Internship")
        val humanoria = arrayOf("A", industri, "NA", "Humaniora")

        return decition(idPerson, humanoria as Array<Serializable>)
    }

    private fun cpl5(): String {
        val industri = arrayOf("A", "NA", "NA", "Industry Internship")
        val humanoria = arrayOf("A", industri, "NA", "Humaniora")

        return decition(idPerson, humanoria as Array<Serializable>)
    }

    private fun cpl6(): String {
        val bachelor = arrayOf("A", "A", "NA", "Bachelor Thesis")

        return decition(idPerson, bachelor as Array<Serializable>)
    }

    private fun cpl7(): String {
        val industri = arrayOf("A", "NA", "NA", "Industry Internship")
        val humanoria = arrayOf("A", industri, "NA", "Humaniora")

        return decition(idPerson, humanoria as Array<Serializable>)
    }

    private fun cpl8(): String {
        val intro = arrayOf("A", "A", "NA", "Introduction to Algorithm")
        val web = arrayOf("NA", intro, "null", "Web Progamming")
        val comp1 = arrayOf("NA", "A", "null", "Computation 1")
        val game = arrayOf(comp1, web, "NA", "Game Design")
        val ai = arrayOf("A", game, "null", "Artificial Neural Network")

        return decition(idPerson, ai as Array<Serializable>)
    }

    private fun cpl9(): String {
        val thesis = arrayOf( "A", "A", "NA", "Bachelor Thesis")

        return decition(idPerson, thesis as Array<Serializable>)
    }

    private fun cpl10(): String {
        val industri = arrayOf("A", "NA", "NA", "Industry Internship")
        val software = arrayOf(industri, "NA", "NA", "Software Development")

        return decition(idPerson, software as Array<Serializable>)
    }

    private fun cpl11(): String {
        val datstruct1 = arrayOf("A", "NA", "NA", "Data Structure")
        val comp1 = arrayOf("A", "A", "NA", "Computation 1")
        val comp11 = arrayOf("A", "NA", "NA", "Computation 1")
        val indus1 = arrayOf(datstruct1, "NA", "NA", "Industry Internship")
        val indus11 = arrayOf(comp1, "NA", "NA", "Industry Internship")
        val datstruct11 = arrayOf("A", "A", comp11, "Data Structure")
        val comp2 = arrayOf(datstruct11, indus11, indus1, "Computation 2")

        return decition(idPerson, comp2 as Array<Serializable>)
    }

    private fun cpl12(): String {

        val datstruct = arrayOf("A", "NA", "NA", "Data Structure")
        val game = arrayOf(datstruct, "NA", "NA", "Game Design")
        val algo = arrayOf("A", "NA", "NA", "Introduction to Algorithm")
        val game2 = arrayOf("A", "A", "NA", "Game Design")
        val nlp = arrayOf(algo, "null", game, "Natural Language Processing")
        val java = arrayOf("A", game2, nlp, "Java Programming")

        return decition(idPerson, java as Array<Serializable>)
    }

    private fun cpl13(): String {

        val data = arrayOf("A", "NA", "NA", "Data Min. And Data Analytics")
        val ml = arrayOf(data, "NA", "NA", "Machine Learning")
        val industri = arrayOf("A", "NA", "NA", "Industry Internship")
        val ai = arrayOf(industri, "null", ml, "Artificial Intelligence")
        val ann = arrayOf("A", "null", ai, "Artificial Neural Network")

        return decition(idPerson, ann as Array<Serializable>)
    }

    private fun cpl14(): String {
        val techno = arrayOf("A", "NA", "NA", "Technopreneurship")
        val database = arrayOf("A", techno, "null", "Database Systems")
        val industri = arrayOf(database, "A", "A", "Industry Internship")
        val mobprog = arrayOf(industri, "NA", "NA", "Mobile Programming")

        val mobprog2 = arrayOf("A", "A", "NA", "Mobile Programming")
        val database2 = arrayOf(mobprog2, "NA", "NA", "Database Systems")
        val os = arrayOf(database2, mobprog, "NA", "Introduction to Operating Systems")

        val software = arrayOf("A", "null", "NA", "Software Development")
        val big = arrayOf("null", software, "NA", "Big Data")
        val database3 = arrayOf(big, "A", "NA", "Database Systems")
        val mobprog3 = arrayOf(database3, "A", "NA", "Mobile Programming")
        val intro = arrayOf(mobprog3, "NA", "NA", "Introduction to Algorithm")

        val datstruct = arrayOf(intro, os, "NA", "Data Structure")

        return decition(idPerson, datstruct as Array<Serializable>)
    }

    private fun cpl15(): String {
        val industri = arrayOf("A", "NA", "NA", "Industry Internship")
        val comp = arrayOf("A", industri, "NA", "Computer System")

        return decition(idPerson, comp as Array<Serializable>)
    }

    private fun cpl16(): String {
        val dist = arrayOf("A", "NA", "A", "Distributed System")
        val industry = arrayOf(dist, "A", "NA", "Industry Internship")

        return decition(idPerson, industry as Array<Serializable>)
    }
    private fun cpl17(): String {

        val web = arrayOf("A", "NA", "NA", "Web Progamming")
        val os = arrayOf("null", web, "NA", "Introduction to Operating Systems")

        val trends = arrayOf("A", "NA", "NA", "IT trends")

        val techno = arrayOf(os, "A", trends, "Technopreneurship")

        val comp = arrayOf("A", "A", techno, "Computer And Society")
        val mobprog = arrayOf("A", "NA", "NA", "Mobile Programming")

        val vision = arrayOf(comp, mobprog, "NA", "Computer Vision")

        return decition(idPerson, vision as Array<Serializable>)
    }

    private fun cpl18(): String {

        val bigdata = arrayOf("NA", "null", "A", "Big Data")
        val ml = arrayOf("NA", bigdata, "NA", "Machine Learning")

        val web = arrayOf("A", "NA", "NA", "Web Progamming")

        val thesis = arrayOf(web, "null", ml, "Bachelor Thesis")

        val database = arrayOf("A", "NA", "NA", "Database Systems")
        val big = arrayOf("A", database, "NA", "Big Data")

        val game = arrayOf("A", big, thesis, "Game Design")

        val neutral = arrayOf("A", "null", game, "Artificial Neural Network")

        return decition(idPerson, neutral as Array<Serializable>)
    }

    private fun cpl19(): String {
        val trends = arrayOf("NA", "A", "null", "IT trends")
        val comp1 = arrayOf("NA", trends, "NA", "Computation 1")
        val intro = arrayOf("A", "null", "NA", "Introduction to Algorithm")

        val computersystem = arrayOf(intro, comp1, "NA", "Computer System")

        val vision = arrayOf(computersystem, "NA", "NA", "Computer Vision")
        val ai = arrayOf("A", "null", vision, "Artificial Intelligence")

        val comp11 = arrayOf("A", "NA", "NA", "Computation 1")
        val webdevelop = arrayOf("A", "A", comp11, "Web Development")
        val ann = arrayOf(webdevelop, "null", ai, "Artificial Neural Network")

        return decition(idPerson, ann as Array<Serializable>)
    }
    private fun cpl20(): String {
        val comp = arrayOf("A", "A", "A", "Computer And Society")
        val industry = arrayOf(comp, "A", "null", "Industry Internship")
        val thesis = arrayOf(industry, "A", "A", "Bachelor Thesis")

        val thesis2 = arrayOf("A", "null", "NA", "Bachelor Thesis")
        val comp2 = arrayOf(thesis2, "NA", "NA", "Computer And Society")

        val humaniora = arrayOf(thesis, comp2, "NA", "Humaniora")

        return decition(idPerson, humaniora as Array<Serializable>)
    }

    private fun cpl21(): String {
        val thesis = arrayOf("A", "A", "NA", "Bachelor Thesis")

        return decition(idPerson, thesis as Array<Serializable>)
    }

    private fun cpl22(): String {
        val bigData = arrayOf("NA", "null", "NA", "Big Data")
        val bpr = arrayOf(bigData, "null", "NA", "Business process reengineering")
        val industry = arrayOf("NA", bpr, "NA", "Industry Internship")

        val bigData2 = arrayOf("A", "A", "NA", "Big Data")
        val industry2 = arrayOf(bigData2, "NA", "NA", "Industry Internship")

        val gameDesign = arrayOf("A", industry2, industry, "Game Design")

        val nlp = arrayOf("A", "A", gameDesign, "Natural Language Processing")

        return decition(idPerson, nlp as Array<Serializable>)
    }

    private fun cpl23(): String {
        val industry = arrayOf("A", "NA", "NA", "Industry Internship")

        return decition(idPerson, industry as Array<Serializable>)
    }

    private fun cpl24(): String {
        val java = arrayOf("A", "A", "NA", "Java Programming")
        val techno = arrayOf("A", "NA", "NA", "Technopreneurship")
        val softwaredevelop = arrayOf("A", "NA", "NA", "Software Development")
        val ml = arrayOf(softwaredevelop, techno, java, "Machine Learning")

        val industry = arrayOf("A", "NA", "NA", "Industry Internship")
        val techno2 = arrayOf("A", "A", industry, "Technopreneurship")

        val nlp = arrayOf(techno2, "A", ml, "Natural Language Processing")

        return decition(idPerson, nlp as Array<Serializable>)
    }

    private fun cpl25(): String {
        val java = arrayOf("A", "null", "NA", "Java Programming")
        val mobprog = arrayOf(java, "A", "A", "Mobile Programming")
        val distribute = arrayOf(mobprog, "A", "NA", "Distributed System")
        val ml = arrayOf("A", "A", distribute, "Machine Learning")
        val java2 = arrayOf("A", "A", "NA", "Java Programming")
        val web = arrayOf(ml, java2, "A", "Web Development")

        val ml2 = arrayOf("A", "null", "NA", "Machine Learning")
        val java3 = arrayOf("null", ml2, "NA", "Java Programming")

        val java4 = arrayOf("A", "A", "NA", "Java Programming")

        val nlp = arrayOf(web, java4, java3, "Natural Language Processing")

        return decition(idPerson, nlp as Array<Serializable>)
    }

    private fun cpl26(): String {

        val software = arrayOf("A", "NA", "NA", "Software Development")
        val trend = arrayOf("NA", software, "null", "IT trends")
        val thesis = arrayOf(trend, "null", "NA", "Bachelor Thesis")
        val ai = arrayOf("A", "null", thesis, "Artificial Intelligence")

        val ann = arrayOf("A", "null", ai, "Artificial Neural Network")

        return decition(idPerson, ann as Array<Serializable>)
    }

    private fun cpl27(): String {
        val industry = arrayOf("NA", "A", "null", "Industry Internship")
        val web = arrayOf("NA", "A", industry, "Web Development")
        val ai = arrayOf(web, "null", "NA", "Artificial Intelligence")

        val ann = arrayOf("A", "null", ai, "Artificial Neural Network")

        return decition(idPerson, ann as Array<Serializable>)
    }

    private fun cpl28(): String {
        val techno = arrayOf("A", "NA", "NA", "Technopreneurship")
        val industry = arrayOf(techno, "null", "NA", "Industry Internship")
        val bpr = arrayOf("A", industry, "null", "Business process reengineering")

        val techno2 = arrayOf("A", "NA", "A", "Technopreneurship")

        val game = arrayOf(techno2, bpr, "NA", "Game Design")

        val thesis = arrayOf("A", game, "NA", "Bachelor Thesis")

        return decition(idPerson, thesis as Array<Serializable>)
    }

    private fun cpl29(): String {
        val comp1 = arrayOf("A", "NA", "null", "Computation 1")
        val techno = arrayOf("A", "A", comp1, "Technopreneurship")

        val game = arrayOf("A", "null", "NA", "Game Development")

        val ann = arrayOf(techno, "null", game, "Artificial Neural Network")

        return decition(idPerson, ann as Array<Serializable>)
    }

    private fun cpl30(): String {
        val web = arrayOf("A", "NA", "NA", "Web Development")
        val ai = arrayOf("A", "A", web, "Artificial Intelligence")

        val nlp = arrayOf("null", "A", "NA", "Natural Language Processing")

        val ann = arrayOf(ai, "null", nlp, "Artificial Neural Network")

        return decition(idPerson, ann as Array<Serializable>)
    }

    private fun cpl31(): String {
        val industry = arrayOf("A", "NA", "NA", "Industry Internship")
        val web = arrayOf(industry, "NA", "NA", "Web Development")
        val web2 = arrayOf("NA", "NA", "NA", "Web Development")
        val bigdata  = arrayOf(web, web2, "NA", "Big Data")

        val datamin  = arrayOf(bigdata, "NA", "NA", "Data Min. And Data Analytics")

        val datamin2  = arrayOf("A", "A", "NA", "Data Min. And Data Analytics")
        val web3 = arrayOf("A", datamin2, "NA", "Web Development")

        val ml = arrayOf("A", web3, datamin, "Machine Learning")

        return decition(idPerson, ml as Array<Serializable>)
    }

    private fun cpl32(): String {
        val industry = arrayOf("A", "NA", "NA", "Industry Internship")

        return decition(idPerson, industry as Array<Serializable>)
    }
    private fun cpl33(): String {
        val techno = arrayOf("A", "NA", "NA", "Technopreneurship")

        return decition(idPerson, techno as Array<Serializable>)
    }

    //recursive function
    fun decition(idPersons: String, clos: Array<Serializable>): String {
        var idPerson = ""

        var username = ""
        if(this.username==""){
            username = Function.getPref(mContext, "username")
            idPerson = this.idPerson
        }else{
            username = this.username
            idPerson = this.idCmp
        }

        var clo = db.getClo(clos[3].toString(), idPerson, username)
        var type = ""
        var score = clo.score!!.toFloat()

        if (score >= 3.5) {
            type = getResult(clos[0].toString())
            if (type != "none") return type
            if (clos[0].toString() == "null") return "LULUS"

            return decition(idPerson, clos[0] as Array<Serializable>)
        }
        if (score in 2.5..3.5) {
            type = getResult(clos[1].toString())
            if (type != "none") return type
            if (clos[1].toString() == "null") return "LULUS"

            return decition(idPerson, clos[1] as Array<Serializable>)
        }
        if (score < 2.5) {
            type = getResult(clos[2].toString())
            if (type != "none") return type
            if (clos[2].toString() == "null") return "TIDAK LULUS"

            return decition(idPerson, clos[2] as Array<Serializable>)
        }
        return ""
    }

    private fun getResult(result: String): String {
        var res = ""
        if (result == "A") res =  "LULUS"
        else if (result == "NA") res =  "TIDAK LULUS"
        else res = "none"

        return res
    }


}