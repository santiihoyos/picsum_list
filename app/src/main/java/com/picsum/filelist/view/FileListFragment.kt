package com.picsum.filelist.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.picsum.R
import com.picsum.api.getPicsumImageUrlWithDimens
import com.picsum.filelist.FileListContract
import com.picsum.filelist.di.DaggerFileListComponent
import com.picsum.filelist.di.FileListModule
import com.picsum.filelist.view.adapter.FileListItemAdapter
import com.picsum.filelist.viewmodel.FileItem
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject


class FileListFragment : Fragment(), FileListContract.View {

    @Inject
    lateinit var presenter: FileListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerFileListComponent.builder()
            .fileListModule(FileListModule(this))
            .build()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFileList()
        presenter.getItems()
    }

    private fun setupFileList() = mRecyclerViewList?.run {
        val linearLayout = LinearLayoutManager(context)
        hasFixedSize()
        layoutManager = linearLayout
        adapter = FileListItemAdapter(arrayListOf(), this@FileListFragment::onItemClick)
        addItemDecoration(DividerItemDecoration(context, linearLayout.orientation))
    }

    override fun refreshItems(items: List<FileItem>) {
        (mRecyclerViewList.adapter as FileListItemAdapter).let {
            it.items = items
            it.notifyDataSetChanged()
        }
    }

    override fun showLoading(loading: Boolean) {
        mTextViewError?.visibility = View.GONE
        if (loading) {
            mRecyclerViewList?.visibility = View.GONE
            mProgressBar?.visibility = View.VISIBLE
        } else {
            mRecyclerViewList?.visibility = View.VISIBLE
            mProgressBar?.visibility = View.GONE
        }
    }

    override fun onError(textToShow: String) {
        mProgressBar?.visibility = View.GONE
        mTextViewError?.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

    private fun onItemClick(fileItem: FileItem) {
        val intent = Intent(activity!!, BigViewerActivity::class.java)
        intent.putExtra(
            BigViewerActivity.ARGUMENT_IMAGE_URL,
            getPicsumImageUrlWithDimens(fileItem.id.toString(), 500, 500)
        )
        startActivity(intent)
    }
}