package com.sournary.awesomeenglish.di

import com.sournary.awesomeenglish.ui.menu.MenuViewModel
import org.koin.dsl.module.module
import org.koin.experimental.builder.create

/**
 * Created by fs-sournary.
 * Date: 10/17/18.
 * Description:
 */
val viewModelModule = module(override = true) {
    single { create<MenuViewModel>() }

}
