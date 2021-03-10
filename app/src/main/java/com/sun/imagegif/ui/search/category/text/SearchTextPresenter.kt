package com.sun.imagegif.ui.search.category.text

import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.data.source.remote.OnFetchDataJsonListener
import com.sun.imagegif.data.source.repositories.GifRepository

class SearchTextPresenter(private val gifRepository: GifRepository) : SearchTextContract.Presenter {

    private var view: SearchTextContract.View? = null

    override fun searchWithText(keyword: String) {
        gifRepository.searchWithText(keyword, object : OnFetchDataJsonListener<MutableList<Gif>> {

            override fun onSuccess(data: MutableList<Gif>) {
                view?.showGifs(data)
            }

            override fun onError(e: Exception?) {
                view?.onSearchWithTextError(e)
            }
        })
    }

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun setView(view: SearchTextContract.View?) {
        this.view = view
    }
}
