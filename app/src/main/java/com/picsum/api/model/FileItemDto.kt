package com.picsum.api.model

import com.google.gson.annotations.SerializedName

data class FileItemDto (
    val format: String,
    val width: Int,
    val height: Int,
    @SerializedName("filename") val fileName: String,
    val id: Int,
    val author: String,
    @SerializedName("author_url") val authorUrl: String,
    @SerializedName("post_url") val postUrl: String
)