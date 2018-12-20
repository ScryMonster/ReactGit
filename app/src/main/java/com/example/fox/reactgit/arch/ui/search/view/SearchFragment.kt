package com.example.fox.reactgit.arch.ui.search.view

import android.os.Bundle
import android.view.View
import com.example.fox.reactgit.R
import com.example.fox.reactgit.arch.adapters.UsersAdapter
import com.example.fox.reactgit.arch.ui.base.BaseFragment
import com.example.fox.reactgit.arch.ui.base.rv.OnUserLikedListener
import com.example.fox.reactgit.arch.ui.search.presenter.SearchPresenter
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.utils.ext.attachWithAction
import com.example.fox.reactgit.utils.ext.buildWithAction
import com.example.fox.reactgit.utils.ext.isNotSaved
import com.jakewharton.rxbinding2.widget.RxTextView
import kotlinx.android.synthetic.main.fragment_search.*
import javax.inject.Inject

class SearchFragment @Inject constructor() : BaseFragment(), ISearchView {
    override val layoutId: Int = R.layout.fragment_search

    @Inject lateinit var presenter: SearchPresenter
    @Inject lateinit var adapter: UsersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildGraph()
        presenter.attachWithAction(this){
            validateField(RxTextView.textChanges(git_search))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detach()
    }

    override fun buildGraph() {
        manager.addSearcFragmentComponent().inject(this)
    }

    override fun destroyGraph() {
        manager.removeSearchhFragmentComponent()
    }

    override fun showProgress(tag: Any?) {
        rotateLoading.start()
    }

    override fun hideProgress(tag: Any?) {
        rotateLoading.stop()
    }

    override fun init() {
        initAdapter()
        initRV()
    }


    override fun startSearching(searchTerms: String) {
        presenter.searchGitUser(searchTerms)
    }

    override fun goInDetails(repositories: List<Repository>) {
        parent?.openDetailFragment(repositories)
    }

    override fun setList(list: List<User>) {
        adapter.setNewList(list, true)
    }

    private fun initAdapter() {
        adapter.likeListener = object : OnUserLikedListener {
            override fun like(user: User) {
                user.isNotSaved(presenter,
                        isNotSaved = {
                            saveUser(user)
                        },
                        isSaved = {
                            deleteUser(user)
                        })
            }


        }
    }

    private fun initRV() {
        gitRV.buildWithAction(adapter) { user ->
            presenter.getUserRepositories(user.login)
        }
    }

}