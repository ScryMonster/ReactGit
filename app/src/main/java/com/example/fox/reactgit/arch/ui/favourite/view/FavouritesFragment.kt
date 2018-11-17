package com.example.fox.reactgit.arch.ui.favourite.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.fox.reactgit.R
import com.example.fox.reactgit.arch.adapters.FavouriteAdapter
import com.example.fox.reactgit.arch.ui.base.BaseFragment
import com.example.fox.reactgit.arch.ui.base.rv.OnItemClickedListener
import com.example.fox.reactgit.arch.ui.base.rv.OnItemLikedListener
import com.example.fox.reactgit.arch.ui.favourite.presenter.FavouritePresenter
import com.example.fox.reactgit.arch.ui.search.SearchActivity
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.utils.Constants.FragmentNames.DETAIL_FRAGMENT
import com.like.LikeButton
import kotlinx.android.synthetic.main.fragment_favourite.*
import javax.inject.Inject

class FavouritesFragment @Inject constructor() : BaseFragment(),IFavouriteView {

    @Inject lateinit var presenter: FavouritePresenter
    @Inject lateinit var adapter:FavouriteAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildGraph()
        presenter.run {
            init()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detach()
    }

    override fun setList(list: List<User>) {
        favouriteRV.layoutManager = LinearLayoutManager(context)
        adapter.run{
            setList(list,true)
            setLikeListeneer(object : OnItemLikedListener<User>{
                override fun like(item: User) {
                    item.saved = false
                    presenter.deleteUser(item)
                }

                override fun liked(p0: LikeButton?) {}

                override fun unLiked(p0: LikeButton?) {}

            })

            setClickListener(object :OnItemClickedListener<User>{
                override fun onItemClick(item: User) {
                    presenter.getUserRepositories(item.login)
                }

            })
        }
    }

    override fun replacment(repositories: List<Repository>) {
        (activity as SearchActivity).innerFragmentNavigation(DETAIL_FRAGMENT,repositories)
    }

    override fun setView() = R.layout.fragment_favourite

    override fun buildGraph() {
        manager.addFavouriteComponent().inject(this)
    }

    override fun destroyGraph() {
        manager.removeFavouriteComponent()
    }

    override fun init() {
        presenter.loadUsers()
    }

}