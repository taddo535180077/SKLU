package com.example.sklu.Adapter

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.sklu.Database.CloDatabase
import com.example.sklu.Model.Clo
import com.example.sklu.R


class CloAdapter : RecyclerView.Adapter<CloAdapter.ViewHolder> {
    private var mContext: Context
    private var items: ArrayList<Clo>?
    private var db: CloDatabase
    var v: View? = null



    constructor(mContext: Context, items: ArrayList<Clo>?) {
        this.mContext = mContext
        this.items = items
        db = CloDatabase(mContext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        v = LayoutInflater.from(mContext).inflate(R.layout.clo2, parent, false)
        return ViewHolder(v!!)
    }

    private fun validateInput(string: String): String{
        var score = string.toFloat()
        Log.e("SCORE", "validateInput: $score")
        if(score< 0 || score > 4){
            Toast.makeText(mContext, "Maximum Score is 4", Toast.LENGTH_SHORT).show()
            return ""
        }
        return string
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pos = position
        val item = items?.get(position)
        holder.name.text = item?.name.toString()
        if (item?.score != "0") holder.score.setText(item?.score)
        holder.grade.text = item?.grade.toString()

        holder.score.setOnTouchListener(OnTouchListener { v, event ->
            holder.score.onTouchEvent(event)

            holder.score.setSelection(holder.score.length())
            true
        })


        val mTextWatcher: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(editable: Editable) {
                if (holder.score.text.isNotEmpty()) {
                    holder.score.removeTextChangedListener(this)
                    try {

                        var temp = holder.score.text.toString().replace("[,.0-9]", "")
                        temp = validateInput(temp)
                        holder.score.setText(temp)
                        setValue(pos, temp)

                    } catch (e: Exception) {

                    }
                    holder.score.setSelection(holder.score.text.length)
                    holder.score.addTextChangedListener(this)
                }
            }
        }
        holder.score.addTextChangedListener(mTextWatcher)

    }

    fun setValue(position: Int, value: String){
        items!![position].score = value
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var score: EditText
        var grade: TextView
        var rl1: RelativeLayout

        init {
            name = itemView.findViewById(R.id.name)
            score = itemView.findViewById(R.id.score)
            grade = itemView.findViewById(R.id.grade)
            rl1 = itemView.findViewById(R.id.rl1)
        }
    }

    public fun updateAll() {
        for (i in 0..(items!!.size-1)) {
            var item = items!![i]
            var grade = ""
            if (item.score!!.toFloat()>=3.5) grade = "A"
            else if (item.score!!.toFloat()>=3) grade = "B"
            else if (item.score!!.toFloat()>=2) grade = "C"
            else if (item.score!!.toFloat()>=1) grade = "D"
            else if (item.score!!.toFloat()>=0) grade = "E"
            else grade = "E"
            db.updateClo(item.id, item.score, "", grade)
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