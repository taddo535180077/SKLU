package com.example.sklu.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sklu.Database.FavDatabase
import com.example.sklu.Decision
import com.example.sklu.Function
import com.example.sklu.HomeActivity
import com.example.sklu.Model.Clo
import com.example.sklu.Model.Plo
import com.example.sklu.R

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private var mContext: Context
    private var items: ArrayList<Plo>?
    private var db: FavDatabase
    private var role: String? = ""
    private var username: String?= ""

    constructor(mContext: Context, items: ArrayList<Plo>?, username: String) {
        this.mContext = mContext
        this.items = items
        db = FavDatabase(mContext)
        role = Function.getPref(mContext, "status")
        this.username = username
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(mContext).inflate(R.layout.list, parent, false)
        return ViewHolder(v)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)

        holder.name_tv.text = item?.name.toString()
        var result = Decision(mContext).getPlo(item?.name.toString(), username.toString())
        holder.grade.text = result

    }

    override fun getItemCount(): Int {
        return items!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name_tv: TextView
        var grade: TextView

        init {
            name_tv = itemView.findViewById(R.id.title)
            grade = itemView.findViewById(R.id.grades)
        }
    }


}