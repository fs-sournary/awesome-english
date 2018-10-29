package com.sournary.awesomeenglish.pref

/**
 * Created by fs-sournary.
 * Date: 10/29/18.
 * Description:
 */
interface PrefHelper {

    fun putBoolean(key: String, value: Boolean)

    fun getBoolean(key: String): Boolean

    fun delete(key: String)

    fun clear()
}
