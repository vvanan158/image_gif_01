package com.sun.imagegif.ui.main.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.sun.imagegif.R
import com.sun.imagegif.ui.home.HomeFragment
import com.sun.imagegif.ui.utils.MenuItem
import kotlinx.android.synthetic.main.fragment_container_page.*

class PageContainerFragment : Fragment() {

    private val fragments = mutableListOf<Fragment>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_container_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListFragment()
        fragmentManager?.let {
            viewPagerContainer.adapter = ViewPagerContainerAdapter(it, fragments)
            initItemBottomBar()
        }
    }

    private fun initListFragment() {
        fragments.apply {
            add(MenuItem.HOME.ordinal, HomeFragment.newInstance())
            add(MenuItem.SEARCH.ordinal, HomeFragment.newInstance())
            add(MenuItem.STORAGE.ordinal, HomeFragment.newInstance())
        }
    }

    private fun initItemBottomBar() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeItem -> {
                    viewPagerContainer.currentItem = MenuItem.HOME.ordinal
                    true
                }
                R.id.searchItem -> {
                    viewPagerContainer.currentItem = MenuItem.SEARCH.ordinal
                    true
                }
                R.id.storageItem -> {
                    viewPagerContainer.currentItem = MenuItem.STORAGE.ordinal
                    true
                }
                else -> false
            }
        }
        viewPagerContainer.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) = Unit

            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) = Unit
        })
    }

    companion object {
        fun newInstance() = PageContainerFragment()
    }
}
