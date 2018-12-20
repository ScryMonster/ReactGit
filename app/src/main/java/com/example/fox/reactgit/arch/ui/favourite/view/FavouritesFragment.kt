package com.example.fox.reactgit.arch.ui.favourite.view

import android.os.Bundle
import android.view.View
import com.example.fox.reactgit.R
import com.example.fox.reactgit.arch.adapters.UsersAdapter
import com.example.fox.reactgit.arch.ui.base.BaseFragment
import com.example.fox.reactgit.arch.ui.base.rv.OnUserLikedListener
import com.example.fox.reactgit.arch.ui.favourite.presenter.FavouritePresenter
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.utils.ext.attachWithAction
import com.example.fox.reactgit.utils.ext.buildWithAction
import kotlinx.android.synthetic.main.fragment_favourite.*
import javax.inject.Inject

class FavouritesFragment @Inject constructor() : BaseFragment(), IFavouriteView {

    @Inject
    lateinit var presenter: FavouritePresenter
    @Inject
    lateinit var adapter: UsersAdapter

    override val layoutId: Int = R.layout.fragment_favourite

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildGraph()
        presenter.attachWithAction(this) {
            loadUsers()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        destroyGraph()
        presenter.detach()
    }


    override fun setList(list: List<User>) {
        adapter.setNewList(list, true)
    }

    override fun goInDetails(repositories: List<Repository>) {
        parent?.openDetailFragment(repositories)
    }

    override fun buildGraph() {
        manager.addFavouriteComponent().inject(this)
    }

    override fun destroyGraph() {
        manager.removeFavouriteComponent()
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

    private fun initAdapter() {
        adapter.likeListener = object : OnUserLikedListener {
            override fun like(user: User) {
                user.apply {
                    saved = false
                    presenter deleteUser this
                }
            }


        }
    }

    private fun initRV() {
        favouriteRV.buildWithAction(adapter) { user ->
            presenter.getUserRepositories(user.login)
        }
    }

}