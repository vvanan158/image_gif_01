package com.sun.imagegif.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.sun.imagegif.R
import com.sun.imagegif.ui.search.category.gif.SearchGifFragment
import com.sun.imagegif.ui.search.category.text.SearchTextFragment
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    private val pagerAdapter by lazy {
        SearchPagerAdapter(requireFragmentManager())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        handleEvents()
    }

    private fun initViews() {
        initViewPager()
        initTabLayout()
    }

    private fun handleEvents() {
        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { pagerAdapter.searchGif(it) }
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })
    }

    private fun initViewPager() {
        viewPagerSearch.adapter = pagerAdapter.apply {
            addFragment(SearchGifFragment.newInstance())
            addFragment(SearchTextFragment.newInstance())
        }
    }

    private fun initTabLayout() {
        tabLayoutSearch.setupWithViewPager(viewPagerSearch)
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}
