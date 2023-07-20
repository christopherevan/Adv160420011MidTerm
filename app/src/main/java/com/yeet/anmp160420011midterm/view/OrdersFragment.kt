package com.yeet.anmp160420011midterm.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.model.Order
import com.yeet.anmp160420011midterm.viewmodel.OrderViewModel

class OrdersFragment : Fragment() {
    private lateinit var viewModel: OrderViewModel
    private val orderListAdapter = OrderListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val shared = context?.getSharedPreferences(R.string.preference_file_key.toString(), Context.MODE_PRIVATE)
        val id = shared!!.getInt(R.string.user_id_key.toString(), 0)

        viewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
        viewModel.fetch(id)

        val rv: RecyclerView = view.findViewById(R.id.rvOrders)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = orderListAdapter
        observe()
    }

    private fun observe() {
//        val rv: RecyclerView = requireView().findViewById(R.id.rvOrders)

        viewModel.ordersLD.observe(viewLifecycleOwner, Observer {
            orderListAdapter.updateOrders(it as ArrayList<Order>)
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            val pb: ProgressBar = requireView().findViewById(R.id.pbRvOrders)

            if (it == true) {
                pb.visibility = View.VISIBLE
            } else {
                pb.visibility = View.GONE
            }
        })
    }
}