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
import com.yeet.anmp160420011midterm.databinding.BannerItemBinding
import com.yeet.anmp160420011midterm.databinding.MenuItemBinding
import com.yeet.anmp160420011midterm.model.Banner
import com.yeet.anmp160420011midterm.model.Menu
import com.yeet.anmp160420011midterm.util.loadImage

class BannerAdapter(private val bannerList:ArrayList<Banner>)
    : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>(),ButtonBannerClickListener
{
    class BannerViewHolder(var view: BannerItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = BannerItemBinding.inflate(inflater, parent, false)
        return BannerViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.view.banner = bannerList[position]
        holder.view.buttonListener = this
        /*val btnMore: Button = holder.view.findViewById(R.id.btnBannerShowMore)
        val txtTitle: TextView = holder.view.findViewById(R.id.txtBannerTitle)
        val txtSponsor: TextView = holder.view.findViewById(R.id.txtBannerSponsor)
        val img: ImageView = holder.view.findViewById(R.id.imgBanner)
        val progressBar: ProgressBar = holder.view.findViewById(R.id.progressBarBanner)

        btnMore.setOnClickListener {
//            val action = HomeFragmentDirections.actionRestoDetailFromHome(bannerList[position].id)
//            Navigation.findNavController(it).navigate(action)
        }

        txtTitle.text = bannerList[position].title
        txtSponsor.text = "Sponsored by " + bannerList[position].sponsor
        img.loadImage(bannerList[position].bannerLink, progressBar)*/
    }

    override fun getItemCount(): Int {
        return bannerList.size
    }

    fun updateBannerList(newBannerList: List<Banner>) {
        bannerList.clear()
        bannerList.addAll(newBannerList)
        notifyDataSetChanged()
    }

    override fun onButtonBannerClick(v: View){
        val uuid = v.tag.toString().toInt()
        val action = HomeFragmentDirections.actionRestoDetailFromHome(uuid)
        Navigation.findNavController(v).navigate(action)
    }
}