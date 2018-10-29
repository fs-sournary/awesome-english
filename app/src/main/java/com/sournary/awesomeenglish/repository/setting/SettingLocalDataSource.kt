package com.sournary.awesomeenglish.repository.setting

import com.sournary.awesomeenglish.pref.PrefHelper

/**
 * Created by fs-sournary.
 * Date: 10/29/18.
 * Description:
 */
class SettingLocalDataSource(private val prefHelper: PrefHelper) : SettingDataSource.Local {

    override fun saveDBStatus(isFullExtra: Boolean) {
        prefHelper.putBoolean(DB_STATUS, isFullExtra)
    }

    override fun getDbStatus(): Boolean = prefHelper.getBoolean(DB_STATUS)

    companion object {

        private const val DB_STATUS = "db_status"
    }
}
