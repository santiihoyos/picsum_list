package com.picsum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.picsum.filelist.view.FileListFragment

/**
 * Change on master 1
 */
class MainActivity : AppCompatActivity() {

    /**
     * Second change in miRama
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFileList()
    }

    /**
     * First change in miRama
     */
    private fun showFileList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivity_fragment_container, FileListFragment())
            .commit()
    }
}
