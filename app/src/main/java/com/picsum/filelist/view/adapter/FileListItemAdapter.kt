package com.picsum.filelist.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.picsum.R
import com.picsum.api.getPicsumImageUrlWithDimens
import com.picsum.filelist.viewmodel.FileItem
import com.picsum.setImageUrl
import kotlinx.android.synthetic.main.recycler_fileitem.view.*

class FileListItemAdapter(var items: List<FileItem>) :
    RecyclerView.Adapter<FileListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_fileitem, parent, false)
        return FileListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: FileListItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}

class FileListItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textViewName: TextView = view.mTextViewFileNameFileItem
    private val imageViewPhoto: ImageView = view.mImageViewImage
    private val textViewAuthor: TextView = view.mTextViewAuthorFileItem

    fun bind(fileItem: FileItem) {
        textViewName.text = fileItem.fileName
        textViewAuthor.text = fileItem.author
        //setImageUrl is a extension on ImageView
        imageViewPhoto.setImageUrl(getPicsumImageUrlWithDimens("${fileItem.id}", 100, 100))
    }

}