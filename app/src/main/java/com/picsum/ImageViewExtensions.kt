package com.picsum

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImageUrl(imageUrl: String) {
    Glide.with(this).load(imageUrl)
        .placeholder(R.drawable.ic_image_gray_50dp)
        .into(this)
}