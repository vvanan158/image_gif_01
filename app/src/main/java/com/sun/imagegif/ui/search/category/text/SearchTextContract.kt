package com.sun.imagegif.ui.search.category.text

import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.utils.BasePresenter
import java.lang.Exception

interface SearchTextContract {

    interface Presenter : BasePresenter<View> {

        fun searchWithText(keyword: String)
    }

    interface View {

        fun showGifs(gifs: MutableList<Gif>)

        fun onSearchWithTextError(e: Exception?)
    }
}
