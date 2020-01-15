package com.picsum

import com.nhaarman.mockitokotlin2.*
import com.picsum.filelist.FileListContract
import com.picsum.filelist.presenter.FileListPresenter
import com.picsum.filelist.viewmodel.FileItem
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FileListPresenterUnitTest {

    private val fakeResultsNotSorted = arrayListOf(
        FileItem("", 0, 0, "", 0, "z", "", ""),
        FileItem("", 0, 0, "", 0, "b", "", ""),
        FileItem("", 0, 0, "", 0, "a", "", ""),
        FileItem("", 0, 0, "", 0, "c", "", "")
    )

    /**
     * Test get list items use case
     * -test on result with any results ORDERED ok
     * -test invocation of loading events for view
     */
    @Test
    @Suppress("UNCHECKED_CAST")
    fun getItems_okResult() {
        val view = mock<FileListContract.View>()

        //test ok response with sorted list by author
        val okRepo = mock<FileListContract.Repository> {
            on {
                getItems(any(), any())
            }.doAnswer {
                (it.arguments[0] as (List<FileItem>) -> Unit).invoke(fakeResultsNotSorted)
            }
        }
        val mockPresenter = FileListPresenter(view, okRepo)
        mockPresenter.getItems()

        verify(view, atLeast(1)).showLoading(true)
        verify(view, atLeast(1)).refreshItems(
            arrayListOf(
                fakeResultsNotSorted[2],
                fakeResultsNotSorted[1],   //ordered manually for avoid use sortBy function used in presenter...
                fakeResultsNotSorted[3],
                fakeResultsNotSorted[0]
            )
        )
        verify(view, atLeast(1)).showLoading(false)
    }

    /**
     * Test get list items use case with error
     * -test on error callback
     * -test invocation of loading events for view
     * -test view was notified with same error message
     */
    @Test
    @Suppress("UNCHECKED_CAST")
    fun getItems_onError() {
        val view = mock<FileListContract.View>()

        //test with bad response with sorted list by author
        val okRepo = mock<FileListContract.Repository> {
            on {
                getItems(any(), any())
            }.doAnswer {
                (it.arguments[1] as (Throwable) -> Unit).invoke(Exception("error on test"))
            }
        }
        val mockPresenter1 = FileListPresenter(view, okRepo)
        mockPresenter1.getItems()

        verify(view, atLeast(1)).showLoading(true)
        verify(view, atLeast(0)).refreshItems(any())  //check that in result is not invo..
        verify(view, atLeast(1)).onError(eq("error on test"))
        verify(view, atLeast(1)).showLoading(false)
    }
}
