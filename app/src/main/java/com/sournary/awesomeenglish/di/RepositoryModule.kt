package com.sournary.awesomeenglish.di

import com.sournary.awesomeenglish.repository.ev.EVDataSource
import com.sournary.awesomeenglish.repository.ev.EVLocalDataSource
import com.sournary.awesomeenglish.repository.ev.EVRepository
import com.sournary.awesomeenglish.repository.setting.SettingDataSource
import com.sournary.awesomeenglish.repository.setting.SettingLocalDataSource
import com.sournary.awesomeenglish.repository.setting.SettingRepository
import org.koin.dsl.module.module
import org.koin.experimental.builder.create

/**
 * Created by fs-sournary.
 * Date: 10/24/18.
 * Description:
 */
val localDataSourceModule = module(override = true) {
    single<EVDataSource.Local> { create<EVLocalDataSource>() }
    single<SettingDataSource.Local> { create<SettingLocalDataSource>() }
}

val remoteDataSourceModule = module(override = true) {

}

val repositoryModule = module(override = true) {
    single { create<EVRepository>() }
    single { create<SettingRepository>() }
}
