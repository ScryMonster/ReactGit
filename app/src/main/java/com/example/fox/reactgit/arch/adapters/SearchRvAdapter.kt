package com.example.fox.reactgit.arch.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.fox.reactgit.R
import com.example.fox.reactgit.arch.ui.base.rv.BaseRecyclerViewHolder
import com.example.fox.reactgit.arch.ui.base.rv.OnItemClickListener
import com.example.fox.reactgit.di.scopes.SearchScope as Search
import com.example.fox.reactgit.dto.User
import com.example.fox.reactgit.utils.inflate
import com.example.fox.reactgit.utils.loadUrl
import kotlinx.android.synthetic.main.git_user.view.*
import javax.inject.Inject

@Search
class SearchRvAdapter @Inject constructor()
    : RecyclerView.Adapter<SearchRvAdapter.GithubUserViewHolder>() {

    private lateinit var clickListener : OnItemClickListener<User>
    private var list :List<User> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = GithubUserViewHolder(parent?.inflate(R.layout.git_user)!!)

    override fun getItemCount() = list.size

    fun setListener(clickListener: OnItemClickListener<User>){
        this.clickListener = clickListener
    }

    fun setItems(items:List<User>,notify:Boolean = false){
        list = items
        if (notify) notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder?, position: Int) {
        val user = list[position]
        holder?.bind(user,position)
    }

    private fun callOnItemClick(user:User){
        clickListener.onItemClick(user)
    }


    inner class GithubUserViewHolder(view: View) : BaseRecyclerViewHolder<User>(view) {


        override fun bind(item: User, position: Int) {
            item.run {
                itemView.organisation_img loadUrl avatarUrl
                itemView.organisation_name.text = login
                itemView.organisation_info.text = score
                itemView.organisation_url.text = url
            }
            itemView.setOnClickListener {
                callOnItemClick(item)
            }
        }
    }
}