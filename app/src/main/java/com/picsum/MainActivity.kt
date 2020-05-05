package com.picsum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.picsum.filelist.view.FileListFragment

class MainActivity : AppCompatActivity() {

    /**
     * Cambio 2 en Rama 1
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFileList()
    }

    /**
     * Change on Rama1
     */
    private fun showFileList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivity_fragment_container, FileListFragment())
            .commit()
    }
}
