package com.picsum.filelist.presenter

import com.picsum.filelist.FileListContract
import com.picsum.filelist.domain.FileListRepository

class FileListPresenter(
    val view: FileListContract.View,
    val repo: FileListContract.Repository
) : FileListContract.Presenter {

    override fun getItems() {
        view.showLoading(true)
        repo.getItems({ result ->
            view.showLoading(false)
            view.refreshItems(result.sortedBy { it.author })
        }, { error ->
            view.showLoading(false)
            view.onError(error.message ?: "")
        })
    }
}