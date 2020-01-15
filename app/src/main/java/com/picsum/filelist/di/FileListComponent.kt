package com.picsum.filelist.di

import com.picsum.filelist.view.FileListFragment
import dagger.Component

@Component(
    modules = [
        FileListModule::class
    ]
)
interface FileListComponent {

    fun inject(fileListFragment: FileListFragment)

}