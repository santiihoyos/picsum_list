package com.picsum.base

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.picsum.R

/**
 * Extension on ImageView for allow load images only with url.
 */
fun ImageView.setImageUrl(imageUrl: String) {
    Glide.with(this).load(imageUrl)
        .placeholder(R.drawable.ic_image_gray_50dp)
        .into(this)
}