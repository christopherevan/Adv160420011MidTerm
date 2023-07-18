package com.yeet.anmp160420011midterm.view

import android.annotation.SuppressLint
import android.util.Log
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
import com.yeet.anmp160420011midterm.model.Resto
import com.yeet.anmp160420011midterm.util.loadImage

class HomeRestoAdapter(private val restoList:ArrayList<Resto>)
    : RecyclerView.Adapter<HomeRestoAdapter.HomeRestoViewHolder>()
{
    class HomeRestoViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRestoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.explore_resto_horizontal_item, parent, false)
        return HomeRestoViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HomeRestoViewHolder, position: Int) {
        Log.d("aa", restoList.toString())
        val txtName: TextView = holder.view.findViewById(R.id.txtRestoNameHomeHorizontal)
        val txtLocation: TextView = holder.view.findViewById(R.id.txtRestoLocHomeHorizontal)
        val btnDetail: Button = holder.view.findViewById(R.id.btnDetailRestoHomeHorizontal)
        val img: ImageView = holder.view.findViewById(R.id.imgRestoHomeHorizontal)
        val progressBar: ProgressBar = holder.view.findViewById(R.id.progressBarRestoHomeHorizontal)

        txtName.text = restoList[position].name
        txtLocation.text = restoList[position].relativeLocation
        btnDetail.setOnClickListener {
//            val action = HomeFragmentDirections.actionRestoDetailFromHome(restoList[position].id)
//            Navigation.findNavController(it).navigate(action)
        }

        img.loadImage(restoList[position].imageUrl, progressBar)
    }

    override fun getItemCount(): Int {
        return restoList.size
    }

    fun updateRestoList(newRestoList: ArrayList<Resto>) {
        restoList.clear()
        restoList.addAll(newRestoList)
        notifyDataSetChanged()
    }
}