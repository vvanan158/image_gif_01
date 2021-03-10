package com.sun.imagegif.ui.search.category.gif

import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.data.source.remote.OnFetchDataJsonListener
import com.sun.imagegif.data.source.repositories.GifRepository

class SearchGifPresenter(private var gifRepository: GifRepository) : SearchGifContract.Presenter {

    private var view: SearchGifContract.View? = null

    override fun searchWithGif(keyword: String) {
        gifRepository.searchWithGif(keyword, object : OnFetchDataJsonListener<MutableList<Gif>> {

            override fun onSuccess(data: MutableList<Gif>) {
                view?.showGifs(data)
            }

            override fun onError(e: Exception?) {
                view?.onSearchWithGifError(e)
            }
        })
    }

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun setView(view: SearchGifContract.View?) {
        this.view = view
    }
}
