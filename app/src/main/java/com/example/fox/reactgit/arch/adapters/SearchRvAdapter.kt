package com.example.fox.reactgit.arch.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.fox.reactgit.R
import com.example.fox.reactgit.di.scopes.SearchScope as Search
import com.example.fox.reactgit.dto.Organisation
import com.example.fox.reactgit.utils.inflate
import com.example.fox.reactgit.utils.loadUrl
import kotlinx.android.synthetic.main.organsation.view.*
import javax.inject.Inject

@Search
class SearchRvAdapter @Inject constructor()
    : RecyclerView.Adapter<SearchRvAdapter.OrganisationViewHolder>() {

    private lateinit var clickListener : View.OnClickListener
    private lateinit var list :List<Organisation>

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = OrganisationViewHolder(parent?.inflate(R.layout.organsation)!!)

    override fun getItemCount() = list.size

    fun setListener(clickListener: View.OnClickListener){
        this.clickListener = clickListener
    }

    fun setItems(items:List<Organisation>){
        list = items
    }

    override fun onBindViewHolder(holder: OrganisationViewHolder?, position: Int) {
        val organisation = list[position]
        holder?.bind(organisation)
    }


    inner class OrganisationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(organisation: Organisation) {
            organisation.run {
                itemView.organisation_img loadUrl avatarUrl
                itemView.organisation_name.text = login
            }
        }
    }
}