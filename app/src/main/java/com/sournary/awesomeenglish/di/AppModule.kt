package com.sournary.awesomeenglish.di

import com.sournary.awesomeenglish.db.EVDb
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

/**
 * Created by fs-sournary.
 * Date: 10/24/18.
 * Description:
 */
val appModule = module {
    single { EVDb.getInstance(androidContext()).getEVDao() }
}

val modules = listOf(
    localDataSourceModule,
    remoteDataSourceModule,
    repositoryModule,
    appModule,
    viewModelModule
)
