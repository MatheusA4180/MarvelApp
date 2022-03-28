package com.example.core.data.network.response

import com.google.gson.annotations.SerializedName

data class ComicResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("thumbnail")
    val thumbnail: ThumbnailResponse
)
