package com.irzstudio.foodapp.ui.explore

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.GridLayout
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.irzstudio.foodapp.R
import com.irzstudio.foodapp.adapter.ExploreAdapter
import com.irzstudio.foodapp.listener.OnClickItem
import com.irzstudio.foodapp.listener.OnClickItemAndAdd
import com.irzstudio.foodapp.model.product.ProductEntity
import com.irzstudio.foodapp.ui.detailproduct.DetailProductActivity
import com.irzstudio.foodapp.utill.Constant
import kotlinx.android.synthetic.main.activity_detail_product.*
import kotlinx.android.synthetic.main.fragment_explore.*
import org.koin.android.viewmodel.ext.android.viewModel

class ExploreFragment : Fragment(R.layout.fragment_explore) {

    private val viewModel: ExploreViewModel by viewModel()

    private val exploreAdapter: ExploreAdapter by lazy {
        ExploreAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et_search.requestFocus()
        searchProduct()
        observeSearch()
        setListSearch()

    }

    private fun searchProduct() {
        et_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(qword: String?): Boolean {
                et_search.clearFocus()
                viewModel.requestProductQuery(qword)
                return true
            }

            override fun onQueryTextChange(qword: String?): Boolean {
                return false
            }
        })
    }

    private fun observeSearch() {
        viewModel.searchProduct.observe(viewLifecycleOwner, {
            exploreAdapter.setDataAdapter(it)
        })
    }

    private fun setListSearch() {
        rv_explore.setHasFixedSize(true)
        rv_explore.adapter = exploreAdapter
        rv_explore.layoutManager = GridLayoutManager(activity, 2)
        exploreAdapter.onClickListener = object : OnClickItemAndAdd {
            override fun onClick(productEntity: ProductEntity) {
                navigationToDetail(productEntity)
            }
            override fun onClickAdd(productEntity: ProductEntity) {
                addProductToCart(productEntity)
            }
        }
    }

    private fun navigationToDetail(productEntity: ProductEntity) {
        val intent = Intent(activity, DetailProductActivity::class.java)
        intent.putExtra(Constant.DATA, productEntity)
        startActivity(intent)
    }

    private fun addProductToCart(productEntity: ProductEntity) {
        if (productEntity.qty == 0) {
            viewModel.addToCahar(productEntity)
            Toast.makeText(activity, "Product added to cart", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.removeProductCart(productEntity)
        }
    }
}

