package com.sournary.awesomeenglish.di

import com.sournary.awesomeenglish.MainViewModel
import com.sournary.awesomeenglish.ui.menu.MenuViewModel
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

/**
 * Created by fs-sournary.
 * Date: 10/17/18.
 * Description:
 */
val viewModelModule = module(override = true) {
    viewModel<MenuViewModel>()
    viewModel<MainViewModel>()
}
