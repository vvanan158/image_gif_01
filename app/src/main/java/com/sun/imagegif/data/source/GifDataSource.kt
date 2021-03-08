package com.sun.imagegif.data.source

import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.data.source.remote.OnFetchDataJsonListener

interface GifDataSource {

    interface Remote {
        fun getTrending(listener: OnFetchDataJsonListener<MutableList<Gif>>)
    }
}
