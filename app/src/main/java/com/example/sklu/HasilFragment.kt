package com.example.sklu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sklu.Adapter.HasilAdapter
import com.example.sklu.Database.CloDatabase
import com.example.sklu.Model.Clo
import kotlinx.android.synthetic.main.fragment_hasil.*

class HasilFragment(val homeActivity: HomeActivity) : Fragment() {

    var item = ArrayList<Clo>()
    fun getData() {
        var id = Function.getPref(homeActivity, "idCmp")
        item = CloDatabase(homeActivity).getCloResult(id)!!

        val llm = LinearLayoutManager(homeActivity)
        llm.orientation = LinearLayoutManager.VERTICAL
        val itemAdapter = HasilAdapter(homeActivity, item, homeActivity)
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hasil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }
}