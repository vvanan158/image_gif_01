package com.sun.imagegif.ui.storage

class StoragePresenter : StorageContract.Presenter {

    private var view: StorageContract.View? = null

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun setView(view: StorageContract.View?) {
        this.view = view
    }
}
