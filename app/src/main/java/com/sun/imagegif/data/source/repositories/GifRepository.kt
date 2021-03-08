package com.sun.imagegif.data.source.repositories

import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.data.source.GifDataSource
import com.sun.imagegif.data.source.remote.GifRemoteDataSource
import com.sun.imagegif.data.source.remote.OnFetchDataJsonListener

class GifRepository(private val remote: GifDataSource.Remote) {

    private object Holder {
        val INSTANCE = GifRepository(GifRemoteDataSource.INSTANCE)
    }

    fun getTrending(listener: OnFetchDataJsonListener<MutableList<Gif>>) =
        remote.getTrending(listener)

    fun getRandom(listener: OnFetchDataJsonListener<MutableList<Gif>>) =
        remote.getRandom(listener)

    fun searchWithGif(
        keyword: String,
        listener: OnFetchDataJsonListener<MutableList<Gif>>
    ) {
        remote.searchWithGif(keyword, listener)
    }

    companion object {
        val INSTANCE: GifRepository by lazy {
            Holder.INSTANCE
        }
    }
}
