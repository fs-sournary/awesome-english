package com.sournary.awesomeenglish.di

import org.koin.dsl.module.module

/**
 * Created by fs-sournary.
 * Date: 10/24/18.
 * Description:
 */
val appModule = module {

}

val modules = listOf(
    viewModelModule,
    localDataSourceModule,
    remoteDataSourceModule,
    repositoryModule,
    appModule
)
