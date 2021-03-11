package com.sun.imagegif.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(url: String) {
    Glide.with(context).asGif().load(url).into(this)
}
