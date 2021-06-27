package com.irzstudio.GroceryStore.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.irzstudio.GroceryStore.R
import com.irzstudio.GroceryStore.listener.OnClickItemAndAdd
import com.irzstudio.GroceryStore.model.product.ProductEntity
import kotlinx.android.synthetic.main.item_exclusive_offer.view.*
import java.text.DecimalFormat

class ExclusiveAdapter : RecyclerView.Adapter<ExclusiveAdapter.ExclusiveViewHolder>() {

    private var list: MutableList<ProductEntity> = mutableListOf()
    var onClickListener: OnClickItemAndAdd? =null

    inner class ExclusiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(productEntity: ProductEntity) {

            val price = productEntity.price
            val dec = DecimalFormat("#,###")
            val priceRupiah = dec.format(price)

            itemView.setOnClickListener {
                onClickListener?.onClick(productEntity)
            }

            itemView.btn_exclusive_add_cart.setOnClickListener {
                onClickListener?.onClickAdd(productEntity)
            }

            Glide.with(itemView).load(productEntity.picture).into(itemView.iv_picture)
            itemView.tv_name.text = productEntity.name
            itemView.tv_description.text = productEntity.description
            itemView.tv_price.text = "IDR $priceRupiah"
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