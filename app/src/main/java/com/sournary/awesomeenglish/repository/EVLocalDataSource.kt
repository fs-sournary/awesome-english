package com.sournary.awesomeenglish.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.sournary.awesomeenglish.db.EVDao
import com.sournary.awesomeenglish.model.EVWord

/**
 * Created by fs-sournary.
 * Date: 10/28/18.
 * Description:
 */
class EVLocalDataSource(private val evDao: EVDao) : EVDataSource.Local {

    override fun getSearchWords(suggestion: String, limit: Int): LiveData<PagedList<EVWord>> =
        LivePagedListBuilder(
            evDao.getSearchWords(suggestion, limit),
            PagedList.Config.Builder().setPageSize(PAGE_SIZE).build()
        ).build()

    companion object {

        private const val PAGE_SIZE = 30
    }
}
