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
import com.example.fox.reactgit.utils.ext.attachWithAction
import com.example.fox.reactgit.utils.ext.buildWithAction
import com.example.fox.reactgit.utils.ext.showInfoInSnackBar
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject

class DetailFragment : BaseFragment(), IDetailView {

    @Inject lateinit var presenter:DetailPresenter
    @Inject lateinit var adapter:RepositoriesAdapter


    override val layoutId: Int = R.layout.fragment_detail


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildGraph()
        presenter.attachWithAction(this)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        destroyGraph()
        presenter.detach()
    }

    override fun buildGraph() {
        manager.addDetailComponent().inject(this)
    }

    override fun destroyGraph() {
        manager.removeDetailComponent()
    }

    override fun init() {
        initRV()
        setList()
    }

    override fun setList() {
        val list = arguments?.getParcelableArrayList<Repository>(DETAIL_EXTRA_KEY)
        adapter.setList(list!!)
    }


    private fun initRV() {
        repositoriesRV.buildWithAction(adapter) { user ->
            user.fullName.showInfoInSnackBar(view!!)
        }
    }

    companion object {
        fun newInstance(repositoreis: ArrayList<Repository>)  = DetailFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList(DETAIL_EXTRA_KEY,repositoreis)
            }
        }

        const val DETAIL_EXTRA_KEY = "detail_extra_key"

    }

}