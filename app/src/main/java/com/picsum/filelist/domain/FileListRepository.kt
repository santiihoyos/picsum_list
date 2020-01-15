package com.picsum.filelist.domain

import com.picsum.api.PicsumApi
import com.picsum.api.model.FileItemDto
import com.picsum.filelist.FileListContract
import com.picsum.filelist.viewmodel.FileItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class FileListRepository @Inject constructor() : FileListContract.Repository {

    override fun getItems(
        onResult: (items: List<FileItem>) -> Unit,
        onError: ((Throwable) -> Unit)?
    ) {
        PicsumApi.getInstance().getFileList().enqueue(object : Callback<List<FileItemDto>> {

            override fun onFailure(call: Call<List<FileItemDto>>, t: Throwable) {
                onError?.invoke(t)
            }

            override fun onResponse(c: Call<List<FileItemDto>>, r: Response<List<FileItemDto>>) {
                onResult(r.body()?.toFileItemList() ?: arrayListOf())
            }
        })
    }
}
