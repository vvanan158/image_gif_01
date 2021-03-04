package com.sun.imagegif.data.source.remote.fetchjson

import com.sun.imagegif.data.model.Gif
import com.sun.imagegif.data.model.GifEntry
import com.sun.imagegif.data.model.User
import com.sun.imagegif.data.model.UserEntity
import org.json.JSONObject

class ParseJson {

    fun gifParseJson(jsonObject: JSONObject): Gif {
        return Gif(
            id = jsonObject.getString(GifEntry.ID),
            imageUrl = jsonObject
                .getJSONObject(GifEntry.IMAGE)
                .getJSONObject(GifEntry.ORIGINAL)
                .getString(GifEntry.URL),
            title = jsonObject.getString(GifEntry.TITLE),
            user = userParseJson(jsonObject.getJSONObject(UserEntity.USER))
        )
    }

    private fun userParseJson(jsonObject: JSONObject): User {
        return User(
            name = jsonObject.getString(UserEntity.USERNAME),
            avatarUrl = jsonObject.getString(UserEntity.AVATAR_URL)
        )
    }
}
