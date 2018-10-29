package com.sournary.awesomeenglish.db

import androidx.room.TypeConverter
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

/**
 * Created by fs-sournary.
 * Date: 10/28/18.
 * Description:
 */
object EnglishConverters {

    private const val META =
        "<META http-equiv=\"Content-Type\" content=\"text/html;" + " charset=UTF-8\">\n<link rel=\"Stylesheet\" type=\"text/css\" href=\"dic.css\">"

    @TypeConverter
    @JvmStatic
    fun convertBlobsToString(blobs: ByteArray?): String? =
        if (blobs != null) {
            StringBuilder().append(META).append(String(blobs, StandardCharsets.UTF_8)).toString()
        } else {
            null
        }

    @TypeConverter
    @JvmStatic
    fun convertStringToBolbs(str: String?): ByteArray? =
        str?.toByteArray(Charset.forName("UTF-8"))
}
