package com.yeet.anmp160420011midterm.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.model.Global
import com.yeet.anmp160420011midterm.util.toCurrencyFormat

class CartFragment : Fragment() {
    private lateinit var cartAdapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (arguments != null) {

            cartAdapter = CartAdapter(Global.cart)

            val id = CartFragmentArgs.fromBundle(requireArguments()).restoId
            val name = CartFragmentArgs.fromBundle(requireArguments()).restoName

            val txtName: TextView = view.findViewById(R.id.txtRestoNameCart)
            val rvCart: RecyclerView = view.findViewById(R.id.rvCart)
            val txtSubtotal: TextView = view.findViewById(R.id.txtSubtotalCart)
            val txtPoFee: TextView = view.findViewById(R.id.txtPoFee)
            val txtBalance: TextView = view.findViewById(R.id.txtBalanceCart)
            val txtTotal: TextView = view.findViewById(R.id.txtTotalCart)
            val btnOrder: Button = view.findViewById(R.id.btnPlaceOrder)
            val txtEmpty: TextView = view.findViewById(R.id.txtCartEmpty)

            txtName.text = name
            rvCart.layoutManager = LinearLayoutManager(context)
            rvCart.adapter = cartAdapter

            val poFee = 500
            val sum = Global.cart.sumOf { it.amount * it.price }
            txtSubtotal.text = sum.toString().toCurrencyFormat()
            txtPoFee.text = poFee.toString().toCurrencyFormat()
            txtTotal.text = (sum + poFee).toString().toCurrencyFormat()
            txtBalance.text = Global.userBalance.toString().toCurrencyFormat()

            val orderId = 1268348

            if ((sum + poFee) <= Global.userBalance ) {
                btnOrder.setOnClickListener {
                    val action = CartFragmentDirections.actionOrderDetailFromCart(orderId)
                    Navigation.findNavController(it).navigate(action)
                }
            } else {
                btnOrder.setOnClickListener {
                    Toast.makeText(context, "Insufficient Balance.", Toast.LENGTH_SHORT).show()
                }
            }

            if (Global.cart.isEmpty()) {
                txtEmpty.visibility = View.VISIBLE
                btnOrder.setOnClickListener {
                    Toast.makeText(context, "Cart is empty", Toast.LENGTH_SHORT).show()
                }
            } else {
                txtEmpty.visibility = View.GONE
            }
        }
    }
}