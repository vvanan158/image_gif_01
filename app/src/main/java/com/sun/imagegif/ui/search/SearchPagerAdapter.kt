package com.sun.imagegif.ui.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sun.imagegif.ui.search.category.gif.SearchGifFragment
import com.sun.imagegif.ui.search.category.text.SearchTextFragment
import com.sun.imagegif.utils.TypeSearch

class SearchPagerAdapter(
    fragmentManager: FragmentManager,
    private var fragments: MutableList<Fragment> = mutableListOf()
) : FragmentPagerAdapter(
    fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    override fun getCount() = fragments.size

    override fun getItem(position: Int) = fragments[position]

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            TypeSearch.GIF.ordinal -> TypeSearch.GIF.name
            TypeSearch.TEXT.ordinal -> TypeSearch.TEXT.name
            else -> TypeSearch.GIF.name
        }
    }

    fun searchGif(keyword: String) {
        fragments.forEach {
            when (it) {
                is SearchTextFragment -> it.searchWithText(keyword)
                is SearchGifFragment -> it.searchWithGif(keyword)
            }
        }
    }

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
    }
}
