package com.sournary.awesomeenglish.repository.setting

/**
 * Created by fs-sournary.
 * Date: 10/29/18.
 * Description:
 */
interface SettingDataSource {

    interface Local {

        fun saveDBStatus(isFullExtra: Boolean)

        fun getDbStatus(): Boolean
    }
}
