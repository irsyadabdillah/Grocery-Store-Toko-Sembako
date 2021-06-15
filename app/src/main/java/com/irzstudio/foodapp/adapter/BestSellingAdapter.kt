package com.irzstudio.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.listener.OnClickItemBestSelling
import com.irzstudio.foodapp.model.product.ProductEntity
import kotlinx.android.synthetic.main.item_best_selling.view.*

class BestSellingAdapter : RecyclerView.Adapter<BestSellingAdapter.BestSellingViewHolder>() {

    private var list: MutableList<ProductEntity> = mutableListOf()
    var onClickListener: OnClickItemBestSelling? =null

    inner class BestSellingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(productEntity: ProductEntity) {

            itemView.setOnClickListener {
                onClickListener?.onClick(productEntity)
            }

            Glide.with(itemView).load(productEntity.picture).into(itemView.iv_picture_best_selling)
            itemView.tv_name_best_selling.text = productEntity.name
            itemView.tv_description_best_selling.text = productEntity.description
            itemView.tv_price_best_selling.text = productEntity.price.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellingViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_best_selling, parent, false)
        return BestSellingViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestSellingViewHolder, position: Int) {
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