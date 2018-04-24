package com.example.fox.reactgit.arch.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.fox.reactgit.dto.Organisation
import com.example.fox.reactgit.utils.inflate

class SearchRvAdapter(private val list:List<Organisation>,click:View.OnClickListener) : RecyclerView.Adapter<SearchRvAdapter.OrganisationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = OrganisationViewHolder(parent?.inflate())

    override fun getItemCount()  = list.size

    override fun onBindViewHolder(holder: OrganisationViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    inner class OrganisationViewHolder(view:View) : RecyclerView.ViewHolder(view){

    }
}