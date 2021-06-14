package com.irzstudio.foodapp.ui.explore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.irzstudio.foodapp.R
import kotlinx.android.synthetic.main.fragment_explore.*

class ExploreFragment : Fragment(R.layout.fragment_explore) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et_search.requestFocus()

    }
}