package com.nanamare.mac.koin.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id") val id: Long,
    @SerializedName("albumId") val albumId: Long,
    @SerializedName("title") val title: String,
    @SerializedName("thumbnailUrl") val thumbnailUrl: String)