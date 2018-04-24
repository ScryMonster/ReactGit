package com.example.fox.reactgit.arch.ui.search

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.fox.reactgit.R
import com.example.fox.reactgit.application.ReactGit
import com.example.fox.reactgit.arch.ui.favourite.view.FavouritesFragment
import com.example.fox.reactgit.arch.ui.search.view.SearchFragment
import com.example.fox.reactgit.utils.Constants.FragmentNames.SEARCH_FRAGMENT
import com.example.fox.reactgit.utils.addFragment
import com.example.fox.reactgit.utils.plus
import com.example.fox.reactgit.utils.replaceFragment
import com.example.fox.reactgit.utils.showInSnackBarIn
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject

class SearchActivity : AppCompatActivity(),ISearchActView {

    private var saved = false
    @Inject lateinit var presenter:SearchActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

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



    override fun showProgress(tag: Any?) {}

    override fun hideProgress(tag: Any?) {}

    override fun buildGraph() {
        (application as ReactGit).manager.addSearchActComponent().inject(this)
    }

    override fun destroyGraph() {
        (application as ReactGit).manager.removeSearchActComponent()
    }

    override fun init() {
        listenBottomClicks()
        supportFragmentManager.addFragment(SearchFragment(),R.id.container,SEARCH_FRAGMENT)
    }

    override fun infoMessage(message: String) {
        message.showInSnackBarIn(root)

    }


    private fun listenBottomClicks(){
        bottomNav.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.search_item ->{ supportFragmentManager.replaceFragment(SearchFragment(),R.id.container) }
                R.id.favourite_item -> { supportFragmentManager.replaceFragment(FavouritesFragment(),R.id.container) }
            }
        }
    }

}
