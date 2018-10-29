package com.sournary.awesomeenglish.model

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 * Created by fs-sournary.
 * Date: 10/28/18.
 * Description:
 */
@Entity(tableName = "word_tbl", primaryKeys = ["word"])
data class EVWord(
    @ColumnInfo(name = "word")
    val word: String = "Unknown word",
    @ColumnInfo(name = "av")
    val fullMean: String? = "Unknown mean",
    @ColumnInfo(name = "dnpn")
    val synonym: String? = "Unknown synonym",
    @ColumnInfo(name = "aa")
    val englishMean: String? = "Unknown mean",
    @ColumnInfo(name = "mean")
    val shortMean: String? = "Unknown mean"
)
