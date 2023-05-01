package com.yeet.anmp160420011midterm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.yeet.anmp160420011midterm.R

class OrderDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (arguments != null) {
            val id = OrderDetailFragmentArgs.fromBundle(requireArguments()).orderId

            val txtOrderId: TextView = view.findViewById(R.id.txtOrderIdOrderDetail)
            val btnComplete: Button = view.findViewById(R.id.btnCompleteOrderDetail)

            txtOrderId.text = id.toString()
            btnComplete.setOnClickListener {
                val action = OrderDetailFragmentDirections.actionOrdersFromDetail()
                Navigation.findNavController(it).navigate(action)
            }
        }


    }
}