package com.sun.imagegif.data.source.remote

interface OnFetchDataJsonListener<T> {
    fun onSuccess(data: MutableList<T>)
    fun onError(e: Exception?)
}
