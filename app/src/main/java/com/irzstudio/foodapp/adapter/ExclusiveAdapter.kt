package com.irzstudio.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.listener.OnClickItemExclusive
import com.irzstudio.foodapp.model.product.ProductEntity
import kotlinx.android.synthetic.main.item_exclusive_offer.view.*

class ExclusiveAdapter : RecyclerView.Adapter<ExclusiveAdapter.ExclusiveViewHolder>() {

    private var list: MutableList<ProductEntity> = mutableListOf()
    var onClickListener: OnClickItemExclusive? =null

    inner class ExclusiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(productEntity: ProductEntity) {

            itemView.setOnClickListener {
                onClickListener?.onClick(productEntity)
            }

            Glide.with(itemView).load(productEntity.picture).into(itemView.iv_picture)
            itemView.tv_name.text = productEntity.name
            itemView.tv_description.text = productEntity.description
            itemView.tv_price.text = productEntity.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExclusiveViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exclusive_offer, parent, false)
        return ExclusiveViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExclusiveViewHolder, position: Int) {
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