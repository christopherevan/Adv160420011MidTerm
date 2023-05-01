package com.yeet.anmp160420011midterm.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.model.Cart
import com.yeet.anmp160420011midterm.model.Global
import com.yeet.anmp160420011midterm.model.Menu
import com.yeet.anmp160420011midterm.util.loadImage
import com.yeet.anmp160420011midterm.util.toCurrencyFormat
import com.yeet.anmp160420011midterm.viewmodel.MenuViewModel

class MenuDetailFragment : Fragment() {
    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (arguments != null) {
            val id = MenuDetailFragmentArgs.fromBundle(requireArguments()).menuId

            viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
            viewModel.fetch(id)

            observe()
        }
    }

    private fun observe() {
        viewModel.menuLD.observe(viewLifecycleOwner, Observer {
            val txtName: TextView = requireView().findViewById(R.id.txtMenuDetailName)
            val txtDesc: TextView = requireView().findViewById(R.id.txtMenuDetailDesc)
            val txtPrice: TextView = requireView().findViewById(R.id.txtMenuDetailPrice)
            val txtQty: EditText = requireView().findViewById(R.id.txtDetailMenuQty)
            val btnCart: Button = requireView().findViewById(R.id.btnMenuDetailCart)
            val img: ImageView = requireView().findViewById(R.id.imgMenuDetail)
            val progressBar: ProgressBar = requireView().findViewById(R.id.progressMenuDetail)

            txtName.text = it.name
            txtDesc.text = it.desc
            txtPrice.text = it.price.toString().toCurrencyFormat()
            txtQty.setText(1.toString())
            img.loadImage(it.imgUrl, progressBar)

            btnCart.setOnClickListener { i ->
                val menu = Cart(it.id, it.name, it.price, txtQty.text.toString().toInt())
                Global.cart.add(menu)
                requireActivity().onBackPressed()
            }
        })
    }
}