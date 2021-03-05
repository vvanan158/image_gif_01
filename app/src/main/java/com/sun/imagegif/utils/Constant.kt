package com.sun.imagegif.utils

import com.sun.imagegif.BuildConfig

object Constant {
    const val BASE_URL = "https://api.giphy.com/v1/"
    const val BASE_API_KEY = "?api_key=" + BuildConfig.API_KEY
    const val TYPE_GIF = "gifs/"
    const val TYPE_TEXT = "texts/"
    const val TRENDING = "trending"
    const val RANDOM = "random"
    const val SEARCH = "search"
    const val LIMIT = "&limit=10"
}
