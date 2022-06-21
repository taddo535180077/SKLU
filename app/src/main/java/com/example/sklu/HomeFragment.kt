package com.example.sklu

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sklu.Adapter.PloAdapter
import com.example.sklu.Model.Plo
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment(val mContext: Context,val items: ArrayList<Plo>?,val main: HomeActivity) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val llm = LinearLayoutManager(mContext)
        llm.orientation = LinearLayoutManager.VERTICAL
        val itemAdapter = PloAdapter(mContext, items, main,"home")
        itemAdapter.notifyDataSetChanged()
        recycler.setLayoutManager(llm)
        recycler.adapter = itemAdapter
    }

}