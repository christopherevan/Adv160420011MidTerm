package com.yeet.anmp160420011midterm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.model.Global
import com.yeet.anmp160420011midterm.viewmodel.RestoViewModel

class ExploreFragment : Fragment() {
    private lateinit var viewModel: RestoViewModel
    private val restoExploreAdapter = ExploreAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Global.cart.clear()

        viewModel = ViewModelProvider(this).get(RestoViewModel::class.java)
        viewModel.fetch()

        val rv: RecyclerView = view.findViewById(R.id.rvExplore)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = restoExploreAdapter

        val refreshLayout: SwipeRefreshLayout = view.findViewById(R.id.refreshLayoutExplore)
        refreshLayout.setOnRefreshListener {
            rv.visibility = View.GONE
            viewModel.fetch()
            rv.visibility = View.VISIBLE
            refreshLayout.isRefreshing = false
        }

        observe()
    }

    private fun observe() {
        val rv: RecyclerView = requireView().findViewById(R.id.rvExplore)
        val pb: ProgressBar = requireView().findViewById(R.id.pbExplore)
        val err: TextView = requireView().findViewById(R.id.txtErrExplore)

        viewModel.restoLD.observe(viewLifecycleOwner, Observer {
            restoExploreAdapter.updateExploreList(it)
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                pb.visibility = View.VISIBLE
                err.visibility = View.GONE
            } else {
                pb.visibility = View.GONE
                err.visibility = View.GONE
            }
        })

        viewModel.restoLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                err.visibility = View.VISIBLE
                pb.visibility = View.GONE
            } else {
                err.visibility = View.GONE
            }
        })
    }
}