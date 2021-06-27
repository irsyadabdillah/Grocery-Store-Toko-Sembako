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
import kotlinx.android.synthetic.main.item_product.view.*
import java.text.DecimalFormat

class BeveragesAdapter() : RecyclerView.Adapter<BeveragesAdapter.BeveragesViewHolder>() {

    private var list: MutableList<ProductEntity> = mutableListOf()
    var onClickListener: OnClickItemAndAdd? =null

    inner class BeveragesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(productEntity: ProductEntity) {

            val price = productEntity.price
            val dec = DecimalFormat("#,###")
            val priceRupiah = dec.format(price)

            itemView.setOnClickListener {
                onClickListener?.onClick(productEntity)
            }

            itemView.btn_add_product.setOnClickListener {
                onClickListener?.onClickAdd(productEntity)
            }

            Glide.with(itemView).load(productEntity.picture).into(itemView.iv_picture_product)
            itemView.tv_name_product.text = productEntity.name
            itemView.tv_description_product.text = productEntity.description
            itemView.tv_price_product.text = "IDR $priceRupiah"

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