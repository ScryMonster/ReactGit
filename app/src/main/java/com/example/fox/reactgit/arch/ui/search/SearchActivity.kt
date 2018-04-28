package com.example.fox.reactgit.arch.ui.search

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.fox.reactgit.R
import com.example.fox.reactgit.application.ReactGit
import com.example.fox.reactgit.arch.ui.favourite.view.FavouritesFragment
import com.example.fox.reactgit.arch.ui.search.view.SearchFragment
import com.example.fox.reactgit.utils.Constants.FragmentNames.SEARCH_FRAGMENT
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject
import android.net.NetworkInfo
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.support.v4.app.Fragment
import com.example.fox.reactgit.arch.ui.detail.view.DetailFragment
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.utils.*
import com.example.fox.reactgit.utils.Constants.FragmentNames.DETAIL_FRAGMENT


class SearchActivity : AppCompatActivity(), ISearchActView {

    private var saved = false
    private val networkInfoe by lazy {
        (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
    }

    @Inject
    lateinit var presenter: SearchActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        buildGraph()
        presenter.run {
            attach(this@SearchActivity)
            init()
        }


    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        saved = true
    }

    override fun onStop() {
        super.onStop()
        presenter.detach()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!saved) destroyGraph()
    }

    override fun innerFragmentNavigation(key:String,list:List<Repository>) {
        when(key){
            DETAIL_FRAGMENT -> {
                supportFragmentManager.replaceFragment(DetailFragment.newInstance(list as ArrayList<Repository>),R.id.container)
            }
        }
    }

    override fun showProgress(tag: Any?) {}

    override fun hideProgress(tag: Any?) {}

    override fun buildGraph() {
        (application as ReactGit).manager.addSearchActComponent().inject(this)
    }

    override fun destroyGraph() {
        (application as ReactGit).manager.removeSearchActComponent()
    }

    override fun errorMessage(message: String) {
        message.showInSnackBarInError(root)
    }

    override fun init() {
        listenBottomClicks()
        supportFragmentManager.addFragment(SearchFragment(), R.id.container, SEARCH_FRAGMENT)
        when(checkInternetConnection()){
            false -> {"Please enable Internet connection to use this app".showInSnackBarIn(root)}
        }
    }

    override fun infoMessage(message: String) {
        message.showInSnackBarIn(root)

    }

    override fun checkInternetConnection() = networkInfoe.isConnected


    private fun checkWiFiConnection() = networkInfoe != null && ConnectivityManager.TYPE_WIFI == networkInfoe.type && networkInfoe.isConnected


    private fun listenBottomClicks() {
        bottomNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.search_item -> {
                    if(checkRoutingOnItself(SearchFragment::class.java)) return@setOnNavigationItemReselectedListener
                    else supportFragmentManager.replaceFragment(SearchFragment(), R.id.container)
                }
                R.id.favourite_item -> {
                    if(checkRoutingOnItself(FavouritesFragment::class.java)) return@setOnNavigationItemReselectedListener
                    else supportFragmentManager.replaceFragment(FavouritesFragment(), R.id.container)
                }
            }
        }
    }


    private fun checkRoutingOnItself(clazz:Class<out Fragment>):Boolean{
        val fragment = supportFragmentManager.findFragmentById(R.id.container)
        return fragment.javaClass.name == clazz.name
    }

}
