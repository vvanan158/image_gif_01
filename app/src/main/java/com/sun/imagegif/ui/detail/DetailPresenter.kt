package com.sun.imagegif.ui.detail

import com.sun.imagegif.ui.home.HomeContract

class DetailPresenter : DetailContract.Presenter {

    private var view: HomeContract.View? = null

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun setView(view: DetailContract.View?) {
        this.view = view
    }
}
