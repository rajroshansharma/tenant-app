package com.android.dev.tenatapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.dev.tenatapp.R
import com.android.dev.tenatapp.model.history

class RecyclerAdapter(var data:List<history>, var context: Context): RecyclerView.Adapter<RecyclerAdapter.viewHolder>() {

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var purpose: TextView =itemView.findViewById(R.id.purpose)
        var date: TextView =itemView.findViewById(R.id.purpose_detail)
        var fees: TextView =itemView.findViewById(R.id.fees)
        var image: ImageView =itemView.findViewById(R.id.recyclerimage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        var listitem: View =layoutInflater.inflate(R.layout.paid_recycler_view_custom_row,parent,false)
        var viewholder:viewHolder= viewHolder(listitem)
        return viewholder
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var history:history=data.get(position)
        holder.purpose.text=history.purpose
        holder.date.text=history.formonth+history.onmonth
        holder.fees.text=history.fees
        holder.image.setImageBitmap(history.image)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}