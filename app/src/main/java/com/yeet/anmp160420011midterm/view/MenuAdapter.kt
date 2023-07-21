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
import com.yeet.anmp160420011midterm.databinding.MenuItemBinding
import com.yeet.anmp160420011midterm.model.Menu
import com.yeet.anmp160420011midterm.util.loadImage
import com.yeet.anmp160420011midterm.util.toCurrencyFormat

class MenuAdapter(val menuList:ArrayList<Menu>)
    : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>()
{
    class MenuViewHolder(var view: MenuItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = MenuItemBinding.inflate(inflater, parent, false)
        return MenuViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.view.menu = menuList[position]
        /*val txtMenuName: TextView = holder.view.findViewById(R.id.txtMenuName)
        val txtMenuPrice: TextView = holder.view.findViewById(R.id.txtMenuPrice)
        val btnCart: Button = holder.view.findViewById(R.id.btnCartMenu)
        val img: ImageView = holder.view.findViewById(R.id.imgMenu)
        val progressBar: ProgressBar = holder.view.findViewById(R.id.progressMenu)

        txtMenuName.text = menuList[position].name
        txtMenuPrice.text = menuList[position].price.toString().toCurrencyFormat()

        btnCart.setOnClickListener {
//            val action = RestoDetailFragmentDirections.actionMenuDetail(menuList[position].id)
//            Navigation.findNavController(it).navigate(action)
        }

        img.loadImage(menuList[position].imgUrl, progressBar)*/
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    fun updateMenuList(newMenuList: List<Menu>) {
        menuList.clear()
        menuList.addAll(newMenuList)
        notifyDataSetChanged()
    }
}