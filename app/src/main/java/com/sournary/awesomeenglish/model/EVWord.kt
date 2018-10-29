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
    @ColumnInfo(name = "av", typeAffinity = ColumnInfo.BLOB)
    val fullMean: String? = "Unknown mean",
    @ColumnInfo(name = "dnpn", typeAffinity = ColumnInfo.BLOB)
    val synonym: String? = "Unknown synonym",
    @ColumnInfo(name = "aa", typeAffinity = ColumnInfo.BLOB)
    val englishMean: String? = "Unknown mean",
    @ColumnInfo(name = "mean", typeAffinity = ColumnInfo.BLOB)
    val shortMean: String? = "Unknown mean"
)
