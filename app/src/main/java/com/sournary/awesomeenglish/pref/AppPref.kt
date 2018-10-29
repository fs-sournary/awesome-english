package com.sournary.awesomeenglish.pref

import android.content.Context

/**
 * Created by fs-sournary.
 * Date: 10/29/18.
 * Description:
 */
class AppPref(context: Context) : PrefHelper {

    private val sharedPref = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    override fun putBoolean(key: String, value: Boolean) {
        sharedPref.edit().putBoolean(key, value).apply()
    }

    override fun getBoolean(key: String): Boolean = sharedPref.getBoolean(key, false)

    override fun delete(key: String) {
        sharedPref.edit().remove(key).apply()
    }

    override fun clear() {
        sharedPref.edit().clear().apply()
    }
}
