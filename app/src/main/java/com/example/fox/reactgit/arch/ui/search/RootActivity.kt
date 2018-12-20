package com.example.fox.reactgit.arch.ui.search

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.example.fox.reactgit.R
import com.example.fox.reactgit.application.ReactGit
import com.example.fox.reactgit.arch.ui.base.navigation.SuppFragmentNavigator
import com.example.fox.reactgit.arch.ui.detail.view.DetailFragment
import com.example.fox.reactgit.arch.ui.favourite.view.FavouritesFragment
import com.example.fox.reactgit.arch.ui.search.view.SearchFragment
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.utils.enums.Screens
import com.example.fox.reactgit.utils.enums.Screens.*
import com.example.fox.reactgit.utils.exc.LastFragmentException
import com.example.fox.reactgit.utils.ext.addFragment
import com.example.fox.reactgit.utils.ext.replaceFragment
import com.example.fox.reactgit.utils.ext.showErrorInSnackBar
import com.example.fox.reactgit.utils.ext.showInfoInSnackBar
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject

class RootActivity : AppCompatActivity(),IRootView {


    @Inject lateinit var presenter: RootPresenter

    private val navigator  = object : SuppFragmentNavigator{
        override fun goTo(key: Screens, vararg data: Any?) {
            when(key){
                SEARCH -> supportFragmentManager.replaceFragment(SearchFragment(),tag = key.value)
                DETAIL -> supportFragmentManager.replaceFragment(DetailFragment.newInstance(data as ArrayList<Repository>),tag = key.value)
                FAVOURITE -> supportFragmentManager.replaceFragment(FavouritesFragment(),tag = key.value)
            }
        }

        override fun backTo(key: String?, data: Any?) {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack(key, 0)
            } else throw LastFragmentException()
        }

        override fun back() {
            if (supportFragmentManager.backStackEntryCount > 0) supportFragmentManager.popBackStack()
            else throw LastFragmentException()
        }

        override fun replace(key: String, data: Any){}

        override fun systemMessage(message: String) {
            infoMessage(message)
        }

    }

    private val app by lazy {
        application as ReactGit
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_search)
        buildGraph()
        presenter.init()
    }

    override fun onDestroy() {
        super.onDestroy()
        destroyGraph()
    }

    override fun init() {
        setStartFragment()
        initListeners()
        initOther()
    }


    override fun buildGraph() {
        app.manager.addRootActComponent(navigator).inject(this)
    }

    override fun destroyGraph() {
        app.manager.removeRootActComponent()
    }

    override fun infoMessage(message: String) {
        message showInfoInSnackBar  root
    }

    override fun infoMessage(message: Int) {
        message showInfoInSnackBar root
    }

    override fun errorMessage(message: String) {
        message showErrorInSnackBar root
    }

    override fun errorMessage(message: Int) {
        message showErrorInSnackBar root
    }

    override fun switchOffUiInteraction(flag: Boolean) {
        fun blockScreen() {
            window?.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }

        fun unBlockScreen() {
            window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
        if (flag) blockScreen()
        else unBlockScreen()
    }


    private fun initListeners(){}
    private fun initOther(){}

    private fun setStartFragment(){
        supportFragmentManager.addFragment(SearchFragment(),tag = SEARCH.value)
    }

    //region Navigation
    override fun openSearchFragment() {
        presenter.openSearchFragment()
    }

    override fun closeSearchFragment() {
        presenter.closeSearchFragment()
    }

    override fun openFavouriteFragment() {
        presenter.openFavouriteFragment()
    }

    override fun closeFavouriteFragment() {
        presenter.closeFavouriteFragment()
    }

    override fun openDetailFragment(repositories: List<Repository>) {
        presenter.openDetailFragment(repositories)
    }

    override fun closeDetailFragment() {
        presenter.closeDetailFragment()
    }



    //endregion
}