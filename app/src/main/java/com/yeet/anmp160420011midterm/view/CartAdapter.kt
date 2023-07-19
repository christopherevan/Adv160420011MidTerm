package com.yeet.anmp160420011midterm.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.model.Cart
import com.yeet.anmp160420011midterm.util.NotificationHelper
import com.yeet.anmp160420011midterm.util.OrderWorker
import com.yeet.anmp160420011midterm.util.toCurrencyFormat
import java.util.concurrent.TimeUnit

class CartAdapter(private val cartList:ArrayList<Cart>)
    : RecyclerView.Adapter<CartAdapter.CartViewHolder>()
{
    class CartViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cart_item, parent, false)
        return CartViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val txtAmount: TextView = holder.view.findViewById(R.id.txtCartAmount)
        val txtName: TextView = holder.view.findViewById(R.id.txtCartName)
        val txtPrice: TextView = holder.view.findViewById(R.id.txtCartPrice)

        txtAmount.text = cartList[position].amount.toString() + "x"
        txtName.text = cartList[position].name
        txtPrice.text = cartList[position].price.toString().toCurrencyFormat()
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    fun updateCartList(newCartList: ArrayList<Cart>) {
        cartList.clear()
        cartList.addAll(newCartList)
        notifyDataSetChanged()
    }

    fun setNotifications(holder: CartViewHolder) {
        NotificationHelper(holder.view.context)
            .createNotification("Order Placed", "Your order has been sent to the kitchen, we'll notify you when it's ready")

//      ORDER READY NOTIF
        val myWorkRequest = OneTimeWorkRequestBuilder<OrderWorker>()
            .setInitialDelay(15, TimeUnit.SECONDS)
            .setInputData(
                workDataOf(
                    "title" to "Order Ready",
                    "message" to "Your order is ready. Please pick up your order"
                )
            )
            .build()
        WorkManager.getInstance(holder.view.context).enqueue(myWorkRequest)
    }
}