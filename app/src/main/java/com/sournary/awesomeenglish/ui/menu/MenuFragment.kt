package com.sournary.awesomeenglish.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.transition.*
import com.sournary.awesomeenglish.BR
import com.sournary.awesomeenglish.R
import com.sournary.awesomeenglish.databinding.FragmentMenuBinding
import com.sournary.awesomeenglish.ui.BaseFragment
import com.sournary.awesomeenglish.util.*
import kotlinx.android.synthetic.main.fragment_menu.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by fs-sournary.
 * Date: 10/17/18.
 * Description:
 */
class MenuFragment : BaseFragment() {

    private val menuViewModel: MenuViewModel by viewModel()

    private lateinit var rootView: View
    private lateinit var menuBinding: FragmentMenuBinding

    private lateinit var transitionManager: TransitionManager
    private lateinit var menuScene: Scene
    private lateinit var searchScene: Scene
    private lateinit var currentScene: Scene

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        transitionManager = TransitionManager()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        menuBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)
        rootView = menuBinding.root
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        menuBinding.apply {
            setVariable(BR.viewModel, menuViewModel)
            setLifecycleOwner(this@MenuFragment)
            executePendingBindings()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupTransition()
    }

    private fun setupTransition() {
        val transitionView = rootView as ViewGroup
        menuScene = Scene.getSceneForLayout(transitionView, R.layout.fragment_menu, activity!!)
        menuScene.setEnterAction {
            currentScene = menuScene
            setupSearchWidgetInMenuScene()
        }
        // Create transition: menu -> search
        val menuTransition = TransitionSet()
        menuTransition.ordering = TransitionSet.ORDERING_SEQUENTIAL
        val menuFadeTransition = TransitionSet()
        menuFadeTransition.ordering = TransitionSet.ORDERING_TOGETHER
        val toolbarMenuFade = Fade().apply { addTarget(R.id.toolbar) }
        menuFadeTransition.addTransition(toolbarMenuFade)
        val introMenuFade = Fade().apply { addTarget(R.id.constraint_intro) }
        menuFadeTransition.addTransition(introMenuFade)
        val chipMenuFade = Fade().apply { addTarget(R.id.chip_group_choose_language) }
        menuFadeTransition.addTransition(chipMenuFade)
        menuTransition.addTransition(menuFadeTransition)
        val menuChangeBounds = ChangeBounds()
        menuTransition.addTransition(menuChangeBounds)

        searchScene =
                Scene.getSceneForLayout(transitionView, R.layout.fragment_search, activity!!)
        searchScene.setEnterAction {
            currentScene = searchScene
            setupSearchWidgetInSearchScene()
        }
        // Create transition: search -> menu
        val searchTransition = TransitionSet()
        searchTransition.ordering = TransitionSet.ORDERING_SEQUENTIAL
        val searchChangeBounds = ChangeBounds()
        searchTransition.addTransition(searchChangeBounds)
        val searchFadeTransition = TransitionSet()
        searchFadeTransition.ordering = TransitionSet.ORDERING_TOGETHER
        val toolbarSearchFade = Fade().apply { addTarget(R.id.toolbar) }
        searchFadeTransition.addTransition(toolbarSearchFade)
        val introSearchFade = Fade().apply { addTarget(R.id.constraint_intro) }
        searchFadeTransition.addTransition(introSearchFade)
        searchTransition.addTransition(searchFadeTransition)

        transitionManager.setTransition(menuScene, searchScene, menuTransition)
        transitionManager.setTransition(searchScene, menuScene, searchTransition)
        menuScene.enter()
    }

    private fun setupSearchWidgetInMenuScene() {
        customSearchWidget()
        setupSearchListener()
    }

    private fun setupSearchWidgetInSearchScene() {
        customSearchWidget()
        showKeyBoard()
        menuViewModel.searchWords(rootView.search.querySearch())
    }

    private fun customSearchWidget() {
        rootView.search.apply {
            customTextSearch()
            customSearchCloseButton()
            customVoiceSearch()
            enableVoiceSearch()
        }
    }

    private fun setupSearchListener() {
        rootView.search.setOnQueryTextFocusChangeListener { _, b ->
            if (b && currentScene == menuScene) {
                transitionManager.transitionTo(searchScene)
            }
        }
    }

    private fun setupViewModel() {

    }

    override fun onBackPress() {
        if (currentScene == searchScene) {
            transitionManager.transitionTo(menuScene)
            return
        }
        activity!!.finish()
    }
}
