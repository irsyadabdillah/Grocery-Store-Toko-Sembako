package com.irzstudio.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.listener.OnClickItemExclusife
import com.irzstudio.foodapp.model.exclusiveoffer.ExclusiveOfferEntity
import kotlinx.android.synthetic.main.item_exclusive_offer.view.*

class ExclusiveAdapter : RecyclerView.Adapter<ExclusiveAdapter.ExclusiveViewHolder>() {

    private var list: MutableList<ExclusiveOfferEntity> = mutableListOf()
    var onClickListener: OnClickItemExclusife? =null

    inner class ExclusiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(exclusiveOfferEntity: ExclusiveOfferEntity) {

            itemView.setOnClickListener {
                onClickListener?.onClick(exclusiveOfferEntity)
            }

            Glide.with(itemView).load(exclusiveOfferEntity.picture).into(itemView.iv_picture)
            itemView.tv_name.text = exclusiveOfferEntity.name
            itemView.tv_description.text = exclusiveOfferEntity.description
            itemView.tv_price.text = exclusiveOfferEntity.price.toString()
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

    fun setDataAdapter(data: List<ExclusiveOfferEntity>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}