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

class SavedListAdapter(private val savedList:ArrayList<Resto>)
    : RecyclerView.Adapter<SavedListAdapter.SavedViewHolder>()
{
    class SavedViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.card_saved_item, parent, false)
        return SavedViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SavedViewHolder, position: Int) {
        val txtLocation: TextView = holder.view.findViewById(R.id.txtLocationSaved)
        val txtRestoName: TextView = holder.view.findViewById(R.id.txtRestoNameSaved)
        val txtReviews: TextView = holder.view.findViewById(R.id.txtReveiwsSaved)
        val btnDetail: Button = holder.view.findViewById(R.id.btnDetailsRestoSaved)
        val img: ImageView = holder.view.findViewById(R.id.imgRestoSaved)
        val progressBar: ProgressBar = holder.view.findViewById(R.id.progressBarSaved)

        txtLocation.text = savedList[position].relativeLocation
        txtRestoName.text = savedList[position].name
        txtReviews.text = savedList[position].rating.toString() + " - " + savedList[position].countReviews + " reviews"
        btnDetail.setOnClickListener {
//            val action = SavedFragmentDirections.actionRestoDetailFromSaved(savedList[position].id)
//            Navigation.findNavController(it).navigate(action)
        }

        img.loadImage(savedList[position].imageUrl, progressBar)
    }

    override fun getItemCount(): Int {
        return savedList.size
    }


    fun updateSavedList(newRestoList: ArrayList<Resto>) {
        savedList.clear()
        savedList.addAll(newRestoList)
        notifyDataSetChanged()
    }
}
