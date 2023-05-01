package com.yeet.anmp160420011midterm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.model.Global
import com.yeet.anmp160420011midterm.viewmodel.RestoViewModel

class SavedFragment : Fragment() {
    private lateinit var viewModel: RestoViewModel
    private val savedListAdapter = SavedListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Global.cart.clear()

        viewModel = ViewModelProvider(this).get(RestoViewModel::class.java)
        viewModel.fetch_saved()

        val recyclerView: RecyclerView = view.findViewById(R.id.rvSaved)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = savedListAdapter
        observe()
    }

    private fun observe() {
        val rv: RecyclerView = requireView().findViewById(R.id.rvSaved)

        viewModel.restoLD.observe(viewLifecycleOwner, Observer {
            savedListAdapter.updateSavedList(it)
        })
    }
}