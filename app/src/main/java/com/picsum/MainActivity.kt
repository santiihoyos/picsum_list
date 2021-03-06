package com.picsum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.picsum.filelist.view.FileListFragment

/**
 * Cambio 2 en rama master
 */
class MainActivity : AppCompatActivity() {

    /**
     * Third change in miRama2.
     * Second change in miRama2
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFileList()
    }

    /**
     * mi primer cambio en rama5 !!!
     */
    private fun showFileList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainActivity_fragment_container, FileListFragment())
            .commit()
    }
}
