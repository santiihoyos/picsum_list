package com.picsum.filelist.di

import com.picsum.filelist.FileListContract
import com.picsum.filelist.domain.FileListRepository
import com.picsum.filelist.presenter.FileListPresenter
import dagger.Module
import dagger.Provides

@Module
class FileListModule(val view: FileListContract.View) {

    @Provides
    fun provideFileListContractView(): FileListContract.View = view

    @Provides
    fun provideFileListContractPresenter(
        view: FileListContract.View,
        repo: FileListContract.Repository
    ): FileListContract.Presenter {
        return FileListPresenter(view, repo)
    }

    @Provides
    fun provideFileListContractRepo(): FileListContract.Repository = FileListRepository()
}