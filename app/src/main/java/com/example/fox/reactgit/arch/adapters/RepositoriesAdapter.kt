package com.example.fox.reactgit.arch.adapters

import android.view.View
import android.view.ViewGroup
import com.example.fox.reactgit.R
import com.example.fox.reactgit.arch.ui.base.rv.BaseAdapter
import com.example.fox.reactgit.arch.ui.base.rv.BaseViewHolder
import com.example.fox.reactgit.di.scopes.DetailScope as Detail
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.utils.ext.inflate
import kotlinx.android.synthetic.main.git_user_repository.view.*
import javax.inject.Inject

@Detail
class RepositoriesAdapter @Inject constructor() : BaseAdapter<Repository,RepositoriesAdapter.RepositoriesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RepositoriesHolder  = RepositoriesHolder(parent?.inflate(R.layout.git_user_repository)!!)


    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: RepositoriesHolder?, position: Int) {
        holder?.bind(list[position],position)
    }


    inner class RepositoriesHolder(val view: View) :BaseViewHolder<Repository>(view){
        override fun bind(item: Repository, position: Int) {
            itemView.run {
                repositoryName.text = item.name
                repositoryDescription.text = item.description
            }
            itemView.setOnClickListener {
                clickListener.onItemClick(item)
            }
        }

    }
}