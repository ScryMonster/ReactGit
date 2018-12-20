package com.example.fox.reactgit.arch.adapters

import android.view.View
import android.view.ViewGroup
import com.example.fox.reactgit.R
import com.example.fox.reactgit.arch.ui.base.rv.BaseAdapter
import com.example.fox.reactgit.arch.ui.base.rv.BaseViewHolder
import com.example.fox.reactgit.arch.ui.base.rv.OnItemLikedListener
import com.example.fox.reactgit.arch.ui.base.rv.OnUserLikedListener
import com.example.fox.reactgit.di.scopes.FavouriteScope as Favourite
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.utils.ext.inflate
import com.example.fox.reactgit.utils.ext.loadUrl
import kotlinx.android.synthetic.main.git_user.view.*
import javax.inject.Inject


@Favourite
class FavouriteAdapter @Inject constructor()
    : BaseAdapter<User, FavouriteAdapter.GithubUserViewHolder>() {

    override val layoutId: Int = R.layout.git_user

    lateinit var likeListener: OnUserLikedListener


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = GithubUserViewHolder(parent?.inflate(layoutId)!!)

    override fun getItemCount() = list.size



    override fun onBindViewHolder(holder: GithubUserViewHolder?, position: Int) {
        val user = list[position]
        holder?.bind(user,position)
    }

    private fun callOnItemClick(user:User,position: Int){
        clickListener.onItemClick(user,position)
    }


    inner class GithubUserViewHolder(view: View) : BaseViewHolder<User>(view) {


        override fun bind(item: User, position: Int) {
            item.run {
                itemView.organisationImage loadUrl avatarUrl
                itemView.organisationName.text = login
                itemView.organisationInfo.text = score
                itemView.organisationUrl.text = url
            }
            itemView.setOnClickListener {
                callOnItemClick(item,position)
            }
            itemView.likeButton.setOnClickListener{
                likeListener.like(list[position])
            }
        }
    }
}