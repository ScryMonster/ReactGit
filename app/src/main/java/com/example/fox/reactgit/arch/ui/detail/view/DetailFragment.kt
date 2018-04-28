package com.example.fox.reactgit.arch.ui.detail.view

import android.os.Bundle
import com.example.fox.reactgit.R
import com.example.fox.reactgit.arch.ui.base.BaseFragment
import com.example.fox.reactgit.dto.Repository

class DetailFragment : BaseFragment(), IDetailView {

    override fun setView(): Int = R.layout.fragment_detail

    override fun buildGraph() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroyGraph() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun init() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun newInstance(repositoreis: ArrayList<Repository>) : DetailFragment {
            val args = Bundle()
            args.putParcelableArrayList(DETAIL_EXTRA_KEY,repositoreis)

            val detailFragment = DetailFragment()
            detailFragment.arguments = args
            return detailFragment
        }

        const val DETAIL_EXTRA_KEY = "detail_extra_key"

    }

}