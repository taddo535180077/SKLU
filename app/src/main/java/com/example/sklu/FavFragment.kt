package com.example.sklu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sklu.Adapter.PloAdapter
import com.example.sklu.Model.Plo
import kotlinx.android.synthetic.main.fragment_fav.*

class FavFragment(val items: ArrayList<Plo>?, val bool: Boolean, val homeActivity: HomeActivity) : Fragment() {
    var item = ArrayList<Plo>()
    fun getData() {
        if (bool) {
            for (i in items!!){
                if(i.fav == "true") item?.add(i)
            }
            val llm = LinearLayoutManager(homeActivity)
            llm.orientation = LinearLayoutManager.VERTICAL
            val itemAdapter = PloAdapter(homeActivity, item, homeActivity,"fav")
            recycler.setLayoutManager(llm)
            recycler.adapter = itemAdapter
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()

    }
}