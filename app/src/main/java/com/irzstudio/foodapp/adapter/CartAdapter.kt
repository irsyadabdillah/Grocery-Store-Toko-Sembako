package com.irzstudio.foodapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.listener.OnClickItem
import com.irzstudio.foodapp.listener.OnClickItemAddRemove
import com.irzstudio.foodapp.listener.OnTotalChange
import com.irzstudio.foodapp.model.product.ProductEntity
import kotlinx.android.synthetic.main.item_cart.view.*
import kotlinx.android.synthetic.main.item_favorite.view.*
import java.text.DecimalFormat

class CartAdapter(val listener : OnTotalChange): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private var list: MutableList<ProductEntity> = mutableListOf()
    var onClickListener: OnClickItemAddRemove? =null

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(productEntity: ProductEntity) {

            val price = productEntity.priceToQty
            val dec = DecimalFormat("#,###")
            val priceRupiah = dec.format(price)

            itemView.setOnClickListener {
                onClickListener?.onClick(productEntity)
            }

            itemView.btn_delete_cart.setOnClickListener {
                onClickListener?.onClickRemove(productEntity)
            }

            itemView.btn_min_cart.setOnClickListener {
                onClickListener?.onClickSubstract(productEntity)
            }

            itemView.btn_plus_cart.setOnClickListener {
                onClickListener?.onClickAdd(productEntity)
            }


            Glide.with(itemView)
                .load(productEntity.picture)
                .transition(DrawableTransitionOptions.withCrossFade())
                .fitCenter()
                .into(itemView.iv_picture_cart)
            itemView.tv_name_cart.text = productEntity.name
            itemView.tv_description_cart.text = productEntity.description
            itemView.tv_price_cart.text = "IDR $priceRupiah"
            itemView.tv_value_cart.text = productEntity.qty.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setDataAdapter(data: List<ProductEntity>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
        val total = list.sumBy{it.priceToQty}
        listener.onTotalChange(total)
    }

}