package com.irzstudio.foodapp.helper

import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.irzstudio.foodapp.adapter.FavoriteAdapter
import com.irzstudio.foodapp.model.product.ProductEntity
import com.irzstudio.foodapp.ui.detailproduct.DetailProductViewModel
import com.irzstudio.foodapp.ui.explore.ExploreViewModel
import com.irzstudio.foodapp.utill.ProductSavedType
import org.koin.android.viewmodel.ext.android.viewModel

class SwipeToDelete(var onDelete : (pos: Int) -> Unit): ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {

    private val favoriteAdapter: FavoriteAdapter by lazy {
        FavoriteAdapter()
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val pos = viewHolder.adapterPosition
        onDelete.invoke(pos)
        favoriteAdapter.deleteItem(pos)
    }
}

