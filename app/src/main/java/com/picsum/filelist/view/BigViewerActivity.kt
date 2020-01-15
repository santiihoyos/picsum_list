package com.picsum.filelist.view

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.picsum.R
import kotlinx.android.synthetic.main.activity_big_viewer.*

class BigViewerActivity : AppCompatActivity() {

    companion object {
        const val ARGUMENT_IMAGE_URL = "image_url_argument"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_viewer)
        setupViewer()
    }

    private fun setupViewer() {
        val url = intent.getStringExtra(ARGUMENT_IMAGE_URL)
        if (url.isNullOrEmpty()) {
            throw IllegalStateException("Image url must be provided!!!")
        }
        mBigImageViewer.showImage(Uri.parse(url))
        mImageButtonBack.setOnClickListener { finish() }
    }
}