package com.sournary.awesomeenglish.repository

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.sournary.awesomeenglish.model.EVWord

/**
 * Created by fs-sournary.
 * Date: 10/28/18.
 * Description:
 */
interface EVDataSource {

    interface Local {

        fun getSearchWords(suggestion: String, limit: Int): LiveData<PagedList<EVWord>>
    }
}