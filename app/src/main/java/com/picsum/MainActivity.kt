package com.picsum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.picsum.filelist.view.FileListFragment

/**
 * cambio en master 3
 */
class MainActivity : AppCompatActivity() {

    /**
     * cambio 2 en rama 3
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFileList()
    }

    /**
     * cambio 1 en rama 3
     */
    private fun showFileList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivity_fragment_container, FileListFragment())
            .commit()
    }
}
