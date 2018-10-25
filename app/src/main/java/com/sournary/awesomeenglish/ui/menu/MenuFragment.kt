package com.sournary.awesomeenglish.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sournary.awesomeenglish.BR
import com.sournary.awesomeenglish.R
import com.sournary.awesomeenglish.databinding.FragmentMenuBinding
import com.sournary.awesomeenglish.ui.BaseFragment
import org.koin.android.ext.android.inject

/**
 * Created by fs-sournary.
 * Date: 10/17/18.
 * Description:
 */
class MenuFragment : BaseFragment() {

    private val viewModel: MenuViewModel by inject()

    private lateinit var rootView: View
    private lateinit var menuBinding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        menuBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)
        return menuBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        menuBinding.apply {
            setVariable(BR.viewModel, viewModel)
            setLifecycleOwner(this@MenuFragment)
            executePendingBindings()
        }
        customSearchWidget()
    }

    private fun customSearchWidget() {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupViewModel()
    }

    private fun setupViewModel() {

    }

    override fun onBackPress() {
        activity!!.finish()
    }
}
