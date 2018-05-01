package com.example.fox.reactgit.arch.adapters

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.fox.reactgit.R
import com.example.fox.reactgit.arch.ui.base.rv.BaseRVAdapter
import com.example.fox.reactgit.arch.ui.base.rv.BaseRecyclerViewHolder
import com.example.fox.reactgit.di.scopes.DetailScope as Detail
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.utils.inflate
import kotlinx.android.synthetic.main.git_user_repository.view.*
import javax.inject.Inject

@Detail
class RepositoriesAdapter @Inject constructor() : BaseRVAdapter<Repository,RepositoriesAdapter.RepositoriesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RepositoriesHolder  = RepositoriesHolder(parent?.inflate(R.layout.git_user_repository)!!)


    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: RepositoriesHolder?, position: Int) {
        holder?.bind(list[position],position)
    }


    inner class RepositoriesHolder(val view: View) :BaseRecyclerViewHolder<Repository>(view){
        override fun bind(item: Repository, position: Int) {
            itemView.run {
                repositoryName.text = item.name
                repositoryDescription.text = item.description
            }
            itemView.setOnClickListener {
                click.onItemClick(item)
            }
        }

    }
}