package com.irzstudio.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.listener.OnClickItemBestSelling
import com.irzstudio.foodapp.listener.OnClickItemExclusife
import com.irzstudio.foodapp.model.bestselling.BestSellingEntity
import kotlinx.android.synthetic.main.item_best_selling.view.*
import kotlinx.android.synthetic.main.item_exclusive_offer.view.*

class BestSellingAdapter : RecyclerView.Adapter<BestSellingAdapter.BestSellingViewHolder>() {

    private var list: MutableList<BestSellingEntity> = mutableListOf()
    var onClickListener: OnClickItemBestSelling? =null

    inner class BestSellingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(bestSellingEntity: BestSellingEntity) {

            itemView.setOnClickListener {
                onClickListener?.onClick(bestSellingEntity)
            }

            Glide.with(itemView).load(bestSellingEntity.picture).into(itemView.iv_picture_best_selling)
            itemView.tv_name_best_selling.text = bestSellingEntity.name
            itemView.tv_description_best_selling.text = bestSellingEntity.description
            itemView.tv_price_best_selling.text = bestSellingEntity.price.toString()

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

    fun setDataAdapter(data: List<BestSellingEntity>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}