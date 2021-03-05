package com.sun.imagegif.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sun.imagegif.R
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayoutSearch.apply {
            addTab(tabLayoutSearch.newTab().setText(getString(R.string.tab_gif)))
            addTab(tabLayoutSearch.newTab().setText(getString(R.string.tab_text)))
        }
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}
