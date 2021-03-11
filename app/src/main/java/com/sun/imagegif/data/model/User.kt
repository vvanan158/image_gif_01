package com.sun.imagegif.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val name: String = "",
    val avatarUrl: String = ""
) : Parcelable

object UserEntity {
    const val USER = "user"
    const val USERNAME = "username"
    const val AVATAR_URL = "avatar_url"
}
