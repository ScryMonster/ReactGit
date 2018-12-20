package com.example.fox.reactgit.arch.adapters

import android.view.View
import android.view.ViewGroup
import com.example.fox.reactgit.R
import com.example.fox.reactgit.arch.ui.base.rv.BaseAdapter
import com.example.fox.reactgit.arch.ui.base.rv.BaseViewHolder
import com.example.fox.reactgit.arch.ui.base.rv.OnUserLikedListener
import com.example.fox.reactgit.di.scopes.ApplicationScope
import com.example.fox.reactgit.di.scopes.SearchScope as Search
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.utils.ext.inflate
import com.example.fox.reactgit.utils.ext.loadUrl
import kotlinx.android.synthetic.main.git_user.view.*
import javax.inject.Inject

@ApplicationScope
class UsersAdapter @Inject constructor()
    : BaseAdapter<User, UsersAdapter.GithubUserViewHolder>() {

    override val layoutId: Int = R.layout.git_user


    lateinit var likeListener: OnUserLikedListener


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = GithubUserViewHolder(parent?.inflate(layoutId)!!)

    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: GithubUserViewHolder?, position: Int) {
        val user = list[position]
        holder?.bind(user, position)
    }

    private fun callOnItemClick(user: User, position: Int) {
        clickListener.onItemClick(user, position)
    }


    inner class GithubUserViewHolder(view: View) : BaseViewHolder<User>(view) {


        override fun bind(item: User, position: Int) {
            itemView.apply {
                organisationImage loadUrl item.avatarUrl
                organisationName.text = item.login
                organisationInfo.text = item.score
                organisationUrl.text = item.url
                setOnClickListener {
                    callOnItemClick(item, position)
                }
                likeButton.setOnClickListener {
                    likeListener.like(list[position])
                }
            }
        }
    }
}