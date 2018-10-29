package com.sournary.awesomeenglish.repository.setting

/**
 * Created by fs-sournary.
 * Date: 10/29/18.
 * Description:
 */
class SettingRepository(private val local: SettingDataSource.Local) {

    fun saveLocalDbStatus(isFullExtra: Boolean) {
        local.saveDBStatus(isFullExtra)
    }

    fun getLocalDbStatus() = local.getDbStatus()
}
