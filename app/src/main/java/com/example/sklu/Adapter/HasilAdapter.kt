package com.example.sklu.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sklu.Database.CloDatabase
import com.example.sklu.Database.FavDatabase
import com.example.sklu.Function
import com.example.sklu.HomeActivity
import com.example.sklu.Model.Clo
import com.example.sklu.Model.Person
import com.example.sklu.Model.Plo
import com.example.sklu.R
import kotlinx.android.synthetic.main.fragment_fav.*

class HasilAdapter : RecyclerView.Adapter<HasilAdapter.ViewHolder> {
    private var mContext: Context
    private var items: ArrayList<Clo>?
    private var db: FavDatabase
    private var main: HomeActivity
    private var role: String?= ""

    constructor(mContext: Context, items: ArrayList<Clo>?, main: HomeActivity) {
        this.mContext = mContext
        this.items = items
        this.main = main
        db = FavDatabase(mContext)
        role = Function.getPref(mContext, "status")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(mContext).inflate(R.layout.hasil, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)

        holder.name_tv.text = item?.username.toString()

        val list = FavDatabase(mContext).allPlo("admin")
        var items = ArrayList<Plo>()
        for (i in list!!){
            if(i.fav == "true") items?.add(i)
        }
        val llm = LinearLayoutManager(mContext)
        llm.orientation = LinearLayoutManager.VERTICAL
        val itemAdapter = ListAdapter(mContext, items, item?.username.toString())
        holder.recycler.setLayoutManager(llm)
        holder.recycler.adapter = itemAdapter


    }

    override fun getItemCount(): Int {
        return items!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name_tv: TextView
        var recycler: RecyclerView

        init {
            name_tv = itemView.findViewById(R.id.title)
            recycler = itemView.findViewById(R.id.recycler)
        }
    }


}