package com.irzstudio.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.model.product.ProductEntity
import kotlinx.android.synthetic.main.item_product.view.*

class BeveragesAdapter : RecyclerView.Adapter<BeveragesAdapter.BeveragesViewHolder>() {

    private var list: MutableList<ProductEntity> = mutableListOf()

    inner class BeveragesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(productEntity: ProductEntity) {

            Glide.with(itemView).load(productEntity.picture).into(itemView.iv_picture_product)
            itemView.tv_name_product.text = productEntity.name
            itemView.tv_description_product.text = productEntity.description
            itemView.tv_price_product.text = productEntity.price.toString()
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

    fun setDataAdapter(data: List<ProductEntity>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}