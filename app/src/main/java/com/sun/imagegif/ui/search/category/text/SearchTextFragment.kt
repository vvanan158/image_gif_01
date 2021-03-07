package com.sun.imagegif.ui.search.category.text

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sun.imagegif.R
import kotlinx.android.synthetic.main.fragment_search_gif.*
import kotlinx.android.synthetic.main.fragment_search_text.*

class SearchTextFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_text, container, false)
    }

    fun searchWithText(keyword: String) = Unit

    companion object {
        fun newInstance() = SearchTextFragment()
    }
}
