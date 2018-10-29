package com.sournary.awesomeenglish.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.sournary.awesomeenglish.model.EVWord

/**
 * Created by fs-sournary.
 * Date: 10/28/18.
 * Description:
 */
class EVRepository(private val localDataSource: EVDataSource.Local) {

    fun getLocalSearchWords(suggestion: String, limit: Int): LiveData<PagedList<EVWord>> =
        localDataSource.getSearchWords(suggestion, limit)
}
