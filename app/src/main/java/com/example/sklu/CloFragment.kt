package com.example.sklu

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sklu.Adapter.CloAdapter
import com.example.sklu.Database.CloDatabase
import com.example.sklu.Model.Clo
import com.example.sklu.Model.Plo
import kotlinx.android.synthetic.main.fragment_clo.*
import kotlinx.android.synthetic.main.fragment_fav.*
import kotlinx.android.synthetic.main.fragment_fav.recycler
import java.math.RoundingMode
import java.text.DecimalFormat


class CloFragment(val items: ArrayList<Clo>, val homeActivity: HomeActivity, val type: String) :
    Fragment() {
    val itemAdapter = CloAdapter(homeActivity, items)

    var average = ""

    private fun getData() {
        val llm = LinearLayoutManager(homeActivity)
        llm.orientation = LinearLayoutManager.VERTICAL
        recycler.setLayoutManager(llm)
        recycler.adapter = itemAdapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_clo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        title.text = type

        submit.setOnClickListener {
            itemAdapter.updateAll()

            homeActivity.goToClo(type)
        }

        var res = Decision(homeActivity).getPlo(type, "")

        var total: Float = 0.0f
        for (item in items) {

            total = total!!.toFloat() + item.score!!.toFloat()

        }
        if (total == null) average = ""
        else {
            total = total / items!!.size
        }
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        val results = df.format(total)


        result.text = "$res, $results"
    }

}