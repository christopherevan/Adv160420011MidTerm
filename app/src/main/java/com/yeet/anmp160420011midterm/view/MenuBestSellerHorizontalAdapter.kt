package com.yeet.anmp160420011midterm.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.model.Menu
import com.yeet.anmp160420011midterm.util.loadImage
import com.yeet.anmp160420011midterm.util.toCurrencyFormat

class MenuBestSellerHorizontalAdapter(private val menuList:ArrayList<Menu>)
    : RecyclerView.Adapter<MenuBestSellerHorizontalAdapter.MenuViewHolder>() {
    class MenuViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.menu_bestseller_horizontal_item, parent, false)
        return MenuViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val txtMenuName: TextView = holder.view.findViewById(R.id.txtMenuNameBestseller)
        val txtMenuPrice: TextView = holder.view.findViewById(R.id.txtMenuPriceBestseller)
        val btnCart: Button = holder.view.findViewById(R.id.btnCartMenuBestseller)
        val img: ImageView = holder.view.findViewById(R.id.imgMenuBestseller)
        val progressBar: ProgressBar = holder.view.findViewById(R.id.progressMenuBestseller)

        txtMenuName.text = menuList[position].name
        txtMenuPrice.text = menuList[position].price.toString().toCurrencyFormat()

        btnCart.setOnClickListener {
//            val action = RestoDetailFragmentDirections.actionMenuDetail(menuList[position].id)
//            Navigation.findNavController(it).navigate(action)
        }

        img.loadImage(menuList[position].imgUrl, progressBar)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    fun updateMenuList(newMenuList: ArrayList<Menu>) {
        menuList.clear()
        menuList.addAll(newMenuList)
        notifyDataSetChanged()
    }
}