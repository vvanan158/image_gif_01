package com.sun.imagegif.ui.search.category.text

class SearchTextPresenter : SearchTextContract.Presenter {

    private var view: SearchTextContract.View? = null

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun setView(view: SearchTextContract.View?) {
        this.view = view
    }
}
