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
import com.yeet.anmp160420011midterm.model.Resto
import com.yeet.anmp160420011midterm.util.loadImage
import org.w3c.dom.Text

class ExploreAdapter(private val restoList:ArrayList<Resto>)
    : RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>()
{
    class ExploreViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.explore_resto_item, parent, false)
        return ExploreViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        val txtLocation: TextView = holder.view.findViewById(R.id.txtLocationExplore)
        val txtRestoName: TextView = holder.view.findViewById(R.id.txtRestoNameExplore)
        val txtReviews: TextView = holder.view.findViewById(R.id.txtReveiwsExplore)
        val btnDetail: Button = holder.view.findViewById(R.id.btnDetailsRestoExplore)
        val img: ImageView = holder.view.findViewById(R.id.imgRestoExplore)
        val progressBar: ProgressBar = holder.view.findViewById(R.id.progressExplore)

        txtLocation.text = restoList[position].relativeLocation
        txtRestoName.text = restoList[position].name
        txtReviews.text = restoList[position].rating.toString() + " - " + restoList[position].countReviews + " reviews"
        btnDetail.setOnClickListener {
//            val action = ExploreFragmentDirections.actionRestoDetailFromExplore(restoList[position].id)
//            Navigation.findNavController(it).navigate(action)
        }

        img.loadImage(restoList[position].imageUrl, progressBar)
    }

    override fun getItemCount(): Int {
        return restoList.size
    }

    fun updateExploreList(newRestoList: ArrayList<Resto>) {
        restoList.clear()
        restoList.addAll(newRestoList)
        notifyDataSetChanged()
    }
}
