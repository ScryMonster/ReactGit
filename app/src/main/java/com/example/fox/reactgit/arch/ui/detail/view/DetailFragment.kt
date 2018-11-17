package com.example.fox.reactgit.arch.ui.detail.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.fox.reactgit.R
import com.example.fox.reactgit.arch.adapters.RepositoriesAdapter
import com.example.fox.reactgit.arch.ui.base.BaseFragment
import com.example.fox.reactgit.arch.ui.base.rv.OnItemClickedListener
import com.example.fox.reactgit.arch.ui.detail.presenter.DetailPresenter
import com.example.fox.reactgit.dto.Repository
import com.example.fox.reactgit.utils.showInSnackBarIn
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject

class DetailFragment : BaseFragment(), IDetailView {

    @Inject lateinit var presenter:DetailPresenter
    @Inject lateinit var adapter:RepositoriesAdapter

    override fun setView(): Int = R.layout.fragment_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildGraph()
        presenter.run {
            attach(this@DetailFragment)
            init()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detach()
    }

    override fun buildGraph() {
        manager.addDetailComponent().inject(this)
    }

    override fun destroyGraph() {
        manager.removeDetailComponent()
    }

    override fun init() {}

    override fun setList() {
        val list = arguments?.getParcelableArrayList<Repository>(DETAIL_EXTRA_KEY)
        adapter.run {
            setList(list!!)
            setClickListener(object :OnItemClickedListener<Repository>{
                override fun onItemClick(item: Repository) {
                    item.fullName.showInSnackBarIn(view!!)
                }
            })
        }
        repositories_rv.layoutManager = LinearLayoutManager(context)
        repositories_rv.adapter = adapter

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