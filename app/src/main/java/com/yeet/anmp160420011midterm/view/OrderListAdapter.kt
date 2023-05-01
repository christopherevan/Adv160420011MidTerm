package com.yeet.anmp160420011midterm.view

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.model.Order
import com.yeet.anmp160420011midterm.util.toCurrencyFormat

class OrderListAdapter(val orderList:ArrayList<Order>)
    : RecyclerView.Adapter<OrderListAdapter.OrderViewHolder>()
{
    class OrderViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.orders_item, parent, false)
        return OrderViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val txtDate: TextView = holder.view.findViewById(R.id.txtOrdersDate)
        val txtResto: TextView = holder.view.findViewById(R.id.txtOrdersResto)
        val txtCount: TextView = holder.view.findViewById(R.id.txtOrdersCount)
        val txtItems: TextView = holder.view.findViewById(R.id.txtOrdersItems)
        val txtTotalPrice: TextView = holder.view.findViewById(R.id.txtOrdersTotalPrice)
        val chipStatus: Chip = holder.view.findViewById(R.id.chipOrdersStatus)
        val btnDetail: Button = holder.view.findViewById(R.id.btnOrdersDetail)

        txtDate.text = orderList[position].date
        txtResto.text = orderList[position].restoName

        var dispItems = " item"
        if (orderList[position].countItems > 1) {
            dispItems = " items"
        }
        txtCount.text = orderList[position].countItems.toString() + dispItems

        var items = ""
        orderList[position].items.forEach {
            items += "$it, "
        }
        txtItems.text = items.dropLast(2)

        txtTotalPrice.text = orderList[position].totalPrice.toString().toCurrencyFormat()
        chipStatus.text = orderList[position].status

        val states = arrayOf(
            intArrayOf(android.R.attr.state_enabled), // enabled
            intArrayOf(android.R.attr.state_enabled), // disabled
            intArrayOf(android.R.attr.state_checked), // unchecked
            intArrayOf(android.R.attr.state_pressed)  // pressed
        )

        val colors = intArrayOf(
            R.color.myGreen,
            R.color.myGreen,
            R.color.myGreen,
            R.color.myGreen
        )

        val myList = ColorStateList(states, colors)

        if (orderList[position].status == "Completed") {
            chipStatus.chipBackgroundColor = myList
        }

        btnDetail.setOnClickListener {
            val action = OrdersFragmentDirections.actionOrderDetailFromOrders(orderList[position].id)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    fun updateOrders(newOrders: ArrayList<Order>) {
        orderList.clear()
        orderList.addAll(newOrders)
        notifyDataSetChanged()
    }
}
