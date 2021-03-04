package com.sun.imagegif.data.source.remote

interface OnFetchDataJsonListener<T> {
    fun onSuccess(data: T)
    fun onError(e: Exception?)
}
