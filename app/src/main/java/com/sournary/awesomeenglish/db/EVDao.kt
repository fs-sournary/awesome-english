package com.sournary.awesomeenglish.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import com.sournary.awesomeenglish.model.EVWord

/**
 * Created by fs-sournary.
 * Date: 10/30/18.
 * Description:
 */
@Dao
interface EVDao {

    @Query("SELECT * FROM word_tbl WHERE word LIKE :suggestion LIMIT :limit")
    fun getSearchWords(suggestion: String, limit: Int): DataSource.Factory<Int, EVWord>
}
