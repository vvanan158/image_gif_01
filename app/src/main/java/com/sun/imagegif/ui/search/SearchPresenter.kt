package com.sun.imagegif.ui.search

class SearchPresenter : SearchContract.Presenter {

    private var view: SearchContract.View? = null

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun setView(view: SearchContract.View?) {
        this.view = view
    }
}
