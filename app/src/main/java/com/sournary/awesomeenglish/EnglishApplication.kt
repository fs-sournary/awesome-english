package com.sournary.awesomeenglish

import android.app.Application
import com.sournary.awesomeenglish.di.*
import org.koin.android.ext.android.startKoin

/**
 * Created by fs-sournary.
 * Date: 10/17/18.
 * Description:
 */
class EnglishApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val modules = listOf(
            viewModelModule,
            localDataSourceModule,
            remoteDataSourceModule,
            repositoryModule,
            appModule
        )
        startKoin(this, modules)
    }
}