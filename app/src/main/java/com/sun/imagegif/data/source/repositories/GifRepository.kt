package com.sun.imagegif.data.source.repositories

import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.data.source.GifDataSource
import com.sun.imagegif.data.source.remote.OnFetchDataJsonListener
import com.sun.imagegif.data.source.remote.GifRemoteDataSource

class GifRepository(private val remote: GifDataSource.Remote) {

    private object Holder {
        val INSTANCE = GifRepository(GifRemoteDataSource.INSTANCE)
    }

    fun getTrending(listener: OnFetchDataJsonListener<MutableList<Gif>>) =
        remote.getTrending(listener)

    companion object {
        val INSTANCE: GifRepository by lazy {
            Holder.INSTANCE
        }
    }
}
