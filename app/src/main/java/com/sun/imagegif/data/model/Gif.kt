package com.sun.imagegif.data.model

data class Gif(
    val id: String,
    val imageUrl: String,
    val title: String,
    val user: User
)

object GifEntry {
    const val GIF = "gif"
    const val TITLE = "title"
    const val ID = "id"
    const val IMAGE = "images"
    const val FIXED_WIDTH = "fixed_width"
    const val URL = "url"
}
