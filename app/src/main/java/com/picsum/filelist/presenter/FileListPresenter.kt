package com.picsum.filelist.presenter

import com.picsum.filelist.FileListContract
import com.picsum.filelist.domain.FileListRepository

class FileListPresenter(
    val view: FileListContract.View
) : FileListContract.Presenter {

    private val repository: FileListContract.Repository

    init {
        repository = FileListRepository()
    }

    override fun getItems() {
        view.showLoading(true)
        repository.getItems({ result ->
            view.showLoading(false)
            view.refreshItems(result.sortedBy { it.author })
        }, { error ->
            view.onError(error.message ?: "")
        })
    }
}