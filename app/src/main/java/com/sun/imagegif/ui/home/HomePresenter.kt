package com.sun.imagegif.ui.home

import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.data.source.remote.OnFetchDataJsonListener
import com.sun.imagegif.data.source.repositories.GifRepository

class HomePresenter(private val gifRepository: GifRepository) : HomeContract.Presenter {

    private var view: HomeContract.View? = null

    override fun getTrending() {
        gifRepository.getTrending(object : OnFetchDataJsonListener<MutableList<Gif>> {

            override fun onSuccess(data: MutableList<Gif>) {
                view?.onGetTrendingSuccess(data)
            }

            override fun onError(e: Exception?) {
                view?.onError(e)
            }
        })
    }

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun setView(view: HomeContract.View?) {
        this.view = view
    }
}
