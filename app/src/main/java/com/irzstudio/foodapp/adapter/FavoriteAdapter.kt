package com.irzstudio.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.listener.OnClickItemFavorite
import com.irzstudio.foodapp.model.product.ProductEntity
import kotlinx.android.synthetic.main.item_favorite.view.*

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    private var list: MutableList<ProductEntity> = mutableListOf()
    var onClickItemFavorite: OnClickItemFavorite? = null

    inner class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(productEntity: ProductEntity) {

            itemView.setOnClickListener {
                onClickItemFavorite?.onClick(productEntity)
            }

            Glide.with(itemView)
                .load(productEntity.picture)
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(itemView.iv_picture_favorite)
            itemView.tv_name_favorite.text = productEntity.name
            itemView.tv_description_favorite.text = productEntity.description
            itemView.tv_price_favorite.text = productEntity.price.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
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