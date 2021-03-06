package com.sun.imagegif.data.source.remote

import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.data.model.GifEntry
import com.sun.imagegif.data.source.GifDataSource
import com.sun.imagegif.data.source.remote.fetchjson.GetJsonFromUrl
import com.sun.imagegif.utils.Constant

class GifRemoteDataSource : GifDataSource.Remote {

    private object Holder {
        val INSTANCE = GifRemoteDataSource()
    }

    override fun getTrending(listener: OnFetchDataJsonListener<MutableList<Gif>>) {
        val trendingUrl = Constant.BASE_URL +
                Constant.TYPE_GIF +
                Constant.TRENDING +
                Constant.BASE_API_KEY +
                Constant.LIMIT
        GetJsonFromUrl(listener, GifEntry.GIF).execute(trendingUrl)
    }

    override fun getRandom(listener: OnFetchDataJsonListener<MutableList<Gif>>) {
        val randomUrl = Constant.BASE_URL +
                Constant.TYPE_GIF +
                Constant.TRENDING +
                Constant.BASE_API_KEY +
                Constant.LIMIT +
                Constant.OFFSET +
                Constant.PAGE.toString()
        GetJsonFromUrl(listener, GifEntry.GIF).execute(randomUrl)
    }

    companion object {
        val INSTANCE: GifRemoteDataSource by lazy {
            Holder.INSTANCE
        }
    }
}
