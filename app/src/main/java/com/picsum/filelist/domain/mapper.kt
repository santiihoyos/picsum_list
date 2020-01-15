package com.picsum.filelist.domain

import com.picsum.api.model.FileItemDto
import com.picsum.filelist.viewmodel.FileItem

fun FileItemDto.toFileItem() =
    FileItem(format, width, height, fileName, id, author, authorUrl, postUrl)

fun List<FileItemDto>.toFileItemList() = map { it.toFileItem() }