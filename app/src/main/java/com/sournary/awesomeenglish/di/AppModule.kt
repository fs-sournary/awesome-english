package com.sournary.awesomeenglish.di

import com.sournary.awesomeenglish.db.EVDb
import com.sournary.awesomeenglish.pref.AppPref
import com.sournary.awesomeenglish.pref.PrefHelper
import com.sournary.awesomeenglish.rx.AppSchedulerProvider
import com.sournary.awesomeenglish.rx.SchedulerProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module
import org.koin.experimental.builder.create

/**
 * Created by fs-sournary.
 * Date: 10/24/18.
 * Description:
 */
val appModule = module {
    single { EVDb.getInstance(androidContext()).getEVDao() }
    single<SchedulerProvider> { create<AppSchedulerProvider>() }
    single<PrefHelper> { create<AppPref>() }
}

val modules = listOf(
    localDataSourceModule,
    remoteDataSourceModule,
    repositoryModule,
    appModule,
    viewModelModule
)
