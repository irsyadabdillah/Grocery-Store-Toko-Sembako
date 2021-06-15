package com.irzstudio.foodapp.ui.explore

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.irzstudio.foodapp.R
import kotlinx.android.synthetic.main.fragment_explore.*

class ExploreFragment : Fragment(R.layout.fragment_explore) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et_search.requestFocus()



    }
}