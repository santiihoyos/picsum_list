package com.picsum.filelist.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.picsum.R
import com.picsum.api.getPicsumImageUrlWithDimens
import com.picsum.base.setImageUrl
import com.picsum.filelist.viewmodel.FileItem
import kotlinx.android.synthetic.main.recycler_fileitem.view.*


class FileListItemAdapter(
    var items: List<FileItem>,
    var onItemClick: ((fileItem: FileItem) -> Unit)?
) : RecyclerView.Adapter<FileListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_fileitem, parent, false)
        return FileListItemViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: FileListItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}

class FileListItemViewHolder(
    val view: View,
    private val listenerClick: ((fileItem: FileItem) -> Unit)?
) :
    RecyclerView.ViewHolder(view) {

    private val textViewName: TextView = view.mTextViewFileNameFileItem
    private val imageViewPhoto: ImageView = view.mImageViewImage
    private val textViewAuthor: TextView = view.mTextViewAuthorFileItem

    fun bind(fileItem: FileItem) {
        textViewName.text = fileItem.fileName
        textViewAuthor.text = fileItem.author
        //setImageUrl is a extension on ImageView
        imageViewPhoto.setImageUrl(getPicsumImageUrlWithDimens("${fileItem.id}", 100, 100))
        view.setOnClickListener { listenerClick?.invoke(fileItem) }
    }
}