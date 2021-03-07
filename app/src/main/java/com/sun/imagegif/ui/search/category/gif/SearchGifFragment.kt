package com.sun.imagegif.ui.search.category.gif

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sun.imagegif.R

class SearchGifFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_gif, container, false)
    }

    fun searchWithGif(keyword: String) = Unit

    companion object {
        fun newInstance() = SearchGifFragment()
    }
}
