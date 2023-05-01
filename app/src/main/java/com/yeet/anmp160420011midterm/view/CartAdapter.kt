package com.yeet.anmp160420011midterm.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.model.Cart
import com.yeet.anmp160420011midterm.util.toCurrencyFormat

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
}