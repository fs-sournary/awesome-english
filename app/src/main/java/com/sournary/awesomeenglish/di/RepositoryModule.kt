package com.sournary.awesomeenglish.di

import com.sournary.awesomeenglish.repository.EVDataSource
import com.sournary.awesomeenglish.repository.EVLocalDataSource
import com.sournary.awesomeenglish.repository.EVRepository
import org.koin.dsl.module.module
import org.koin.experimental.builder.create

/**
 * Created by fs-sournary.
 * Date: 10/24/18.
 * Description:
 */
val localDataSourceModule = module(override = true) {
    single { create<EVLocalDataSource>() } bind EVDataSource.Local::class
}

val remoteDataSourceModule = module(override = true) {

}

val repositoryModule = module(override = true) {
    single { create<EVRepository>() }
}
