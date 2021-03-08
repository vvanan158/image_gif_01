package com.sun.imagegif.ui.search.category.gif

class SearchGifPresenter : SearchGifContract.Presenter {

    private var view: SearchGifContract.View? = null

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun setView(view: SearchGifContract.View?) {
        this.view = view
    }
}
