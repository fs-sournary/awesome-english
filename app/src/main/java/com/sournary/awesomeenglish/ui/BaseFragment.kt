package com.sournary.awesomeenglish.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.sournary.awesomeenglish.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * Created by fs-sournary.
 * Date: 10/25/18.
 * Description: Base fragment class for all fragment in app.
 */
abstract class BaseFragment : Fragment() {

    private val mainViewModel: MainViewModel by sharedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainViewModel.onBackPressEvent.observe(this, Observer { onBackPress() })
    }

    abstract fun onBackPress()
}
