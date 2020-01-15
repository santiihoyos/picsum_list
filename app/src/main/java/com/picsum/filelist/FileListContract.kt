package com.picsum.filelist

import com.picsum.filelist.viewmodel.FileItem
import java.lang.Exception

interface FileListContract {

    interface View {
        fun refreshItems(items: List<FileItem>)
        fun showLoading(loading: Boolean)
        fun onError(textToShow: String)
    }

    interface Presenter {
        fun getItems()
        fun onDetach()
    }

    interface Repository {
        fun getItems(onResult: (items: List<FileItem>) -> Unit, onError: ((Throwable) -> Unit)?)
    }
}