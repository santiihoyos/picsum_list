package com.picsum.filelist.presenter

import com.picsum.filelist.FileListContract
import javax.inject.Inject

class FileListPresenter @Inject constructor(
    private var view: FileListContract.View?,
    private val repo: FileListContract.Repository
) : FileListContract.Presenter {

    override fun getItems() {
        view?.showLoading(true)
        repo.getItems({ result ->
            view?.showLoading(false)
            view?.refreshItems(result.sortedBy { it.author })
        }, { error ->
            view?.showLoading(false)
            view?.onError(error.message ?: "")
        })
    }

    override fun onDetach() {
        view = null
    }
}