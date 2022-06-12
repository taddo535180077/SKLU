package com.example.sklu

import android.content.Context
import android.util.Log
import com.example.sklu.Database.CloDatabase
import com.example.sklu.Model.Plo
import java.io.Serializable
import kotlin.math.log

class Decision(val mContext: Context) {

    private var db = CloDatabase(mContext)
    private val idPerson = Function.getPref(mContext, "id")

    fun getPlo(type: String): String {

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
        val humanoria = arrayOf("A", "NA", "NA", "Humaniora")
        return decition(idPerson, humanoria as Array<Serializable>)
    }

    private fun cpl2(): String {
        val humanoria = arrayOf("A", "NA", "NA", "Humaniora")

        return decition(idPerson, humanoria as Array<Serializable>)
    }

    private fun cpl3(): String {
        val humanoria = arrayOf("A", "NA", "NA", "Humaniora")
        val industri = arrayOf(humanoria, "NA", "NA", "Industry Internship")

        return decition(idPerson, industri as Array<Serializable>)
    }

    private fun cpl4(): String {
        val humanoria = arrayOf("A", "NA", "NA", "Humaniora")
        val industri = arrayOf(humanoria, "NA", "NA", "Industry Internship")

        return decition(idPerson, industri as Array<Serializable>)
    }

    private fun cpl5(): String {
        val humanoria = arrayOf("A", "NA", "NA", "Humaniora")
        val industri = arrayOf(humanoria, "NA", "NA", "Industry Internship")

        return decition(idPerson, industri as Array<Serializable>)
    }

    private fun cpl6(): String {
        val humanoria = arrayOf("A", "A", "NA", "Humaniora")
        val bachelor = arrayOf(humanoria, "A", "NA", "Bachelor Thesis")

        return decition(idPerson, bachelor as Array<Serializable>)
    }

    private fun cpl7(): String {
        val humanoria = arrayOf("A", "NA", "NA", "Humaniora")
        val industri = arrayOf(humanoria, "NA", "NA", "Industry Internship")

        return decition(idPerson, industri as Array<Serializable>)
    }

    private fun cpl8(): String {
        val computation2 = arrayOf("A", "NA", "NA", "Computation 2")
        val computation1 = arrayOf("A", "A", computation2, "Computation 1")
        val nlp = arrayOf(computation1, "A", "NA", "Natural Language Processing")
        val computation = arrayOf("A", "NA", "NA", "Computation 1")
        val database = arrayOf(nlp, computation, "NA", "Database Systems")

        return decition(idPerson, database as Array<Serializable>)
    }

    private fun cpl9(): String {
        val industri = arrayOf("A", "A", "NA", "Industry Internship")
        val thesis = arrayOf(industri, "A", "NA", "Bachelor Thesis")

        return decition(idPerson, thesis as Array<Serializable>)
    }

    private fun cpl10(): String {
        val industri = arrayOf("A", "NA", "NA", "Industry Internship")
        val software = arrayOf(industri, "NA", "NA", "Software Development")

        return decition(idPerson, software as Array<Serializable>)
    }

    private fun cpl11(): String {
        val industri = arrayOf("A", "NA", "NA", "Industry Internship")
        val software = arrayOf(industri, "NA", "NA", "Software Development")

        return decition(idPerson, software as Array<Serializable>)
    }

    private fun cpl12(): String {
        val java = arrayOf("A", "NA", "NA", "Java Programming")
        val datstruct = arrayOf("A", java, java, "Data Structure")
        val java2 = arrayOf("NA", "A", "NA", "Java Programming")
        val algo = arrayOf(datstruct, java2, "NA", "Introduction to Algorithm")
        val nlp = arrayOf(algo, "NA", "NA", "Natural Language Processing")

        return decition(idPerson, nlp as Array<Serializable>)
    }

    private fun cpl13(): String {
        val industri = arrayOf("A", "A", "NA", "Industry Internship")
        val data = arrayOf("A", "NA", "NA", "Data Min. And Data Analytics")
        val ml = arrayOf(industri, data, "NA", "Machine Learning")

        return decition(idPerson, ml as Array<Serializable>)
    }

    private fun cpl14(): String {
        val datstruct = arrayOf("A", "NA", "NA", "Data Structure")
        val mobprog = arrayOf(datstruct, "NA", "NA", "Mobile Programming")

        return decition(idPerson, mobprog as Array<Serializable>)
    }

    private fun cpl15(): String {
        val industri = arrayOf("A", "NA", "NA", "Industry Internship")
        val comp = arrayOf(industri, "NA", "NA", "Computer System")

        return decition(idPerson, comp as Array<Serializable>)
    }

    private fun cpl16(): String {
        val distributed = arrayOf("A", "null", "NA", "Distributed System")
        val industri = arrayOf(distributed, "NA", "NA", "Industry Internship")

        return decition(idPerson, industri as Array<Serializable>)
    }
    private fun cpl17(): String {
        val trend = arrayOf("NA", "A", "null", "IT trends")
        val nlp = arrayOf("A", trend, "A", "Natural Language Processing")
        val web = arrayOf("A", "NA", nlp, "Web Development")

        return decition(idPerson, web as Array<Serializable>)
    }

    private fun cpl18(): String {
        val database = arrayOf("A", "null", "NA", "Database Systems")
        val datamin = arrayOf("A", "A", database, "Data Min. And Data Analytics")
        val database2 = arrayOf("A", "NA", "NA", "Database Systems")
        val techno = arrayOf(datamin, database2, "NA", "Technopreneurship")

        return decition(idPerson, techno as Array<Serializable>)
    }
    private fun cpl19(): String {
        val comp2 = arrayOf("A", "null", "NA", "Computation 2")
        val comp1 = arrayOf("A", "NA", "NA", "Computation 1")
        val comp11 = arrayOf(comp2, "NA", "NA", "Computation 1")
        val mobprog = arrayOf("A", "NA", "NA", "Mobile Programming")
        val ai = arrayOf("A", comp1, comp11, "Artificial Intelligence")
        val comp = arrayOf(mobprog, "A", "NA", "Computation 1")
        val ml = arrayOf("A", ai, comp, "Machine Learning")

        return decition(idPerson, ml as Array<Serializable>)
    }
    private fun cpl20(): String {
        val human = arrayOf("A", "NA", "NA", "Humaniora")
        val industry = arrayOf("A", human, "NA", "Industry Internship")
        val thesis = arrayOf(industry, "A", "NA", "Bachelor Thesis")

        return decition(idPerson, thesis as Array<Serializable>)
    }
    private fun cpl21(): String {
        val thesis = arrayOf("null", "null", "null", "Bachelor Thesis")

        return decition(idPerson, thesis as Array<Serializable>)
    }
    private fun cpl22(): String {
        val bpr = arrayOf("A", "NA", "NA", "Business process reengineering")
        val bigData = arrayOf("NA", bpr, "null", "Big Data")
        val gameDesign = arrayOf("A", "A", bigData, "Game Design")
        val dataMin = arrayOf("A", "NA", "NA", "Data Min. And Data Analytics")
        val nlp = arrayOf(gameDesign, dataMin, "NA", "Natural Language Processing")

        return decition(idPerson, nlp as Array<Serializable>)
    }
    private fun cpl23(): String {
        val industry = arrayOf("null", "null", "null", "Industry Internship")

        return decition(idPerson, industry as Array<Serializable>)
    }
    private fun cpl24(): String {
        val mobprog = arrayOf("A", "NA", "A", "Mobile Programming")
        val web = arrayOf(mobprog, "NA", "NA", "Web Development")
        val techno = arrayOf("A", "null", "NA", "Technopreneurship")
        val ml = arrayOf("A", techno, web, "Machine Learning")
        val nlp = arrayOf(ml, "NA", "NA", "Natural Language Processing")

        return decition(idPerson, nlp as Array<Serializable>)
    }
    private fun cpl25(): String {
        val web = arrayOf("A", "NA", "NA", "Web Development")
        val java = arrayOf(web, "NA", "NA", "Java Programming")
        val ml = arrayOf("A", java, "NA", "Machine Learning")
        val ml2 = arrayOf("A", "NA", "NA", "Machine Learning")
        val mobprog = arrayOf(ml, ml2, "NA", "Mobile Programming")

        return decition(idPerson, mobprog as Array<Serializable>)
    }
    private fun cpl26(): String {
        val techno = arrayOf("A", "NA", "NA", "Technopreneurship")
        val comp = arrayOf("NA", techno, "NA", "Computer System")
        val trend = arrayOf("A", "null", "NA", "IT trends")
        val ai = arrayOf("A", trend, comp, "Artificial Intelligence")
        val thesis = arrayOf(ai, "A", "NA", "Bachelor Thesis")

        return decition(idPerson, thesis as Array<Serializable>)
    }
    private fun cpl27(): String {
        val datamin = arrayOf("A", "null", "NA", "Data Min. And Data Analytics")
        val thesis = arrayOf("A", "null", "NA", "Bachelor Thesis")
        val bpr = arrayOf(datamin, "NA", "NA", "Business process reengineering")
        val mobprog = arrayOf("A", thesis, "NA", "Mobile Programming")
        val ml = arrayOf("A", bpr, mobprog, "Machine Learning")

        return decition(idPerson, ml as Array<Serializable>)
    }
    private fun cpl28(): String {
        val industry = arrayOf("A", "NA", "NA", "Industry Internship")
        val game = arrayOf("A", industry, "NA", "Game Design")
        val thesis = arrayOf(game, "A", "NA", "Bachelor Thesis")

        return decition(idPerson, thesis as Array<Serializable>)
    }
    private fun cpl29(): String {
        val comp1 = arrayOf("A", "null", "NA", "Computation 1")
        val game = arrayOf("A", "A", comp1, "Game Development")
        val techno = arrayOf("A", "NA", "NA", "Technopreneurship")
        val nlp = arrayOf(game, "A", "NA", "Natural Language Processing")
        val nlp2 = arrayOf(techno, "NA", "A", "Natural Language Processing")
        val algo = arrayOf(nlp, nlp2, "NA", "Introduction to Algorithm")

        return decition(idPerson, algo as Array<Serializable>)
    }
    private fun cpl30(): String {
        val industry = arrayOf("A", "NA", "NA", "Industry Internship")
        val nlp = arrayOf(industry, "NA", "NA", "Natural Language Processing")
        val ai = arrayOf(nlp, "NA", "NA", "Artificial Intelligence")
        val ml = arrayOf("A", "A", ai, "Machine Learning")
        val techno = arrayOf(ml, "NA", "NA", "Technopreneurship")

        return decition(idPerson, techno as Array<Serializable>)
    }
    private fun cpl31(): String {
        val web = arrayOf("A", "A", "NA", "Web Development")
        val datamin = arrayOf(web, "NA", "NA", "Data Min. And Data Analytics")
        val industry = arrayOf("A", "A", "NA", "Industry Internship")
        val ml = arrayOf(industry, datamin, "NA", "Machine Learning")

        return decition(idPerson, ml as Array<Serializable>)
    }
    private fun cpl32(): String {
        val industry = arrayOf("null", "null", "null", "Industry Internship")

        return decition(idPerson, industry as Array<Serializable>)
    }
    private fun cpl33(): String {
        val techno = arrayOf("null", "null", "null", "Technopreneurship")

        return decition(idPerson, techno as Array<Serializable>)
    }

    //recursive function
    fun decition(idPerson: String, clos: Array<Serializable>): String {
        var clo = db.getClo(clos[3].toString(), idPerson)
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
        if (result == "A") return "LULUS"
        else if (result == "NA") return "TIDAK LULUS"
        return "none"
    }


}