package com.irzstudio.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.model.bestselling.BestSellingEntity
import com.irzstudio.foodapp.model.beverages.BeveragesEntity
import kotlinx.android.synthetic.main.item_best_selling.view.*
import kotlinx.android.synthetic.main.item_product.view.*

class BeveragesAdapter : RecyclerView.Adapter<BeveragesAdapter.BeveragesViewHolder>() {

    private var list: MutableList<BeveragesEntity> = mutableListOf()

    inner class BeveragesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(beveragesEntity: BeveragesEntity) {

            Glide.with(itemView).load(beveragesEntity.picture).into(itemView.iv_picture_product)
            itemView.tv_name_product.text = beveragesEntity.name
            itemView.tv_description_product.text = beveragesEntity.description
            itemView.tv_price_product.text = beveragesEntity.price.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeveragesViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return BeveragesViewHolder(view)
    }

    override fun onBindViewHolder(holder: BeveragesViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setDataAdapter(data: List<BeveragesEntity>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}