package com.sun.imagegif.ui.search.category.gif

import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.utils.BasePresenter
import java.lang.Exception

interface SearchGifContract {

    interface Presenter : BasePresenter<View> {

        fun searchWithGif(keyword: String)
    }

    interface View {

        fun showGifs(gifs: MutableList<Gif>)

        fun onSearchWithGifError(e: Exception?)
    }
}
