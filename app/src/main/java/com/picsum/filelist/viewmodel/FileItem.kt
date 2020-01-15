package com.picsum.filelist.viewmodel

data class FileItem(
    val format: String,
    val width: Int,
    val height: Int,
    val fileName: String,
    val id: Int,
    val author: String,
    val authorUrl: String,
    val postUrl: String
)