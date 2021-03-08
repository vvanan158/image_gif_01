package com.sun.imagegif.ui.home

import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.utils.BasePresenter

interface HomeContract {

    interface Presenter : BasePresenter<View> {

        fun getTrending()

        fun getRandom()
    }

    interface View {

        fun onGetTrendingSuccess(gifs: MutableList<Gif>)

        fun onGetRandomSuccess(gifs: MutableList<Gif>)

        fun onError(exception: Exception?)
    }
}
