package com.irzstudio.GroceryStore.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.irzstudio.GroceryStore.R
import com.irzstudio.GroceryStore.model.groceries.GroceriesData
import kotlinx.android.synthetic.main.item_groceries.view.*

class GroceriesAdapter(val onClick : () -> Unit): RecyclerView.Adapter<GroceriesAdapter.GroceriesViewHolder>() {
    private var list: MutableList<GroceriesData> = mutableListOf()

    inner class GroceriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(groceriesdata: GroceriesData) {

            itemView.setOnClickListener {
                if (adapterPosition == 0) {
                    onClick.invoke()
                }
            }

            Glide.with(itemView).load(groceriesdata.picture).into(itemView.iv_picture_groceris)
            itemView.tv_name_groceries.text = groceriesdata.name
            when(adapterPosition){
                0 -> itemView.setBackgroundDrawable(itemView.context.getDrawable(R.drawable.bg_rounded_seashell))
                1 -> itemView.setBackgroundDrawable(itemView.context.getDrawable(R.drawable.bg_rounded_honeydew))
                2 -> itemView.setBackgroundDrawable(itemView.context.getDrawable(R.drawable.bg_rounded_purplesmoke))
                3 -> itemView.setBackgroundDrawable(itemView.context.getDrawable(R.drawable.bg_rounded_mistyrose))
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceriesViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_groceries, parent, false)
        return GroceriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceriesViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setDataAdapter(data: List<GroceriesData>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}