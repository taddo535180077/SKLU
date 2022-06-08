package com.example.sklu.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sklu.Database.FavDatabase
import com.example.sklu.Function
import com.example.sklu.HomeActivity
import com.example.sklu.MainActivity
import com.example.sklu.Model.Plo
import com.example.sklu.R

class PloAdapter : RecyclerView.Adapter<PloAdapter.ViewHolder> {
    private var mContext: Context
    private var items: ArrayList<Plo>?
    private var db: FavDatabase
    private var main: HomeActivity
    private var role: String?= ""

    constructor(mContext: Context, items: ArrayList<Plo>?, main: HomeActivity) {
        this.mContext = mContext
        this.items = items
        this.main = main
        db = FavDatabase(mContext)
        role = Function.getPref(mContext, "status")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(mContext).inflate(R.layout.plo, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.name_tv.text = item?.name.toString()

        if(role=="mhs"){
            holder.fav.visibility = View.GONE
        }else{
            holder.fav.visibility = View.VISIBLE
        }

        if(item?.fav == "true"){
            holder.fav.isChecked = true
        }else{
            holder.fav.isChecked = false
        }

        var status = ""
        holder.fav.setOnCheckedChangeListener { compoundButton, b ->
            if(b==true) status = "true"
            else status = "false"
            db.updateFav(item!!.id, status)
        }

        holder.body.setOnClickListener {
            main.goToClo(item!!.name.toString())
        }

    }

    override fun getItemCount(): Int {
        return items!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name_tv: TextView
        var fav: CheckBox
        var body: RelativeLayout

        init {
            name_tv = itemView.findViewById(R.id.title)
            fav = itemView.findViewById(R.id.star)
            body = itemView.findViewById(R.id.body)
        }
    }

//    private fun update(total: Int, itemId: String){
//        var dbCart = DatabaseCartHandler(mContext)
//        var cart = dbCart.getCart(itemId.toInt())
//
//        if(cart==null) {
//            dbCart.addCart(Cart(total.toString(), itemId))
//        }else{
//            if(total == 0){
//                dbCart.deleteCart(itemId)
//            }else{
//                dbCart.updateCart(cart, total.toString())
//            }
//        }
//        main.checkCart()
//    }

}