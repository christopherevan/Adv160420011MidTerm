package com.yeet.anmp160420011midterm.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.databinding.FragmentHomeBinding
import com.yeet.anmp160420011midterm.databinding.FragmentRestoDetailBinding
import com.yeet.anmp160420011midterm.databinding.RestoReviewItemBinding
import com.yeet.anmp160420011midterm.model.Global
import com.yeet.anmp160420011midterm.model.Resto
import com.yeet.anmp160420011midterm.util.loadImage
import com.yeet.anmp160420011midterm.viewmodel.RestoDetailViewModel

class RestoDetailFragment : Fragment(), ButtonDetailClickListener, ButtonCartClickListener {
    private lateinit var restoDetailViewModel: RestoDetailViewModel
    //private val menuBestSellerHorizontalAdapter = MenuBestSellerHorizontalAdapter(arrayListOf())
    private val menuAdapter = MenuAdapter(arrayListOf())
    private lateinit var dataBinding: FragmentRestoDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentRestoDetailBinding>(inflater, R.layout.fragment_resto_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (arguments != null) {
            val id = RestoDetailFragmentArgs.fromBundle(requireArguments()).restoDetail
            restoDetailViewModel = ViewModelProvider(this).get(RestoDetailViewModel::class.java)
            restoDetailViewModel.fetchResto(id)
            restoDetailViewModel.fetchMenu(id)
            //restoDetailViewModel.fetchMenuBestSeller(id)

            //val rvBestSeller: RecyclerView = view.findViewById(R.id.rvBestSellersRestoDetail)
            //rvBestSeller.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            //rvBestSeller.adapter = menuBestSellerHorizontalAdapter

            val rvMenu: RecyclerView = view.findViewById(R.id.rvMenuRestoDetail)
            val lm = object : LinearLayoutManager(context) {
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }

            rvMenu.layoutManager = lm
            rvMenu.adapter = menuAdapter

            val refreshLayout: SwipeRefreshLayout = view.findViewById(R.id.refreshLayout)
            refreshLayout.setOnRefreshListener {


                restoDetailViewModel.fetchResto(id)
                restoDetailViewModel.fetchMenu(id)
                //restoDetailViewModel.fetchMenuBestSeller(id)

                refreshLayout.isRefreshing = false
            }


            dataBinding.listener = this
            dataBinding.cartListener = this
            observe()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun observe() {
        restoDetailViewModel.restoLD.observe(viewLifecycleOwner, Observer { it ->
//            val txtRelativeLoc: TextView = requireView().findViewById(R.id.txtRelativeLocRestoDetail)
//            val txtRestoName: TextView = requireView().findViewById(R.id.txtRestoNameRestoDetail)
//            val txtLoc: TextView = requireView().findViewById(R.id.txtLocationRestoDetail)
//            val txtRating: TextView = requireView().findViewById(R.id.txtRatingRestoDetail)
//            val txtOpenHours: TextView = requireView().findViewById(R.id.txtOpenHoursRestoDetail)
//            val btnReviews: Button = requireView().findViewById(R.id.btnReviewRestoDetail)
//            val fabCart: FloatingActionButton = requireView().findViewById(R.id.fabCartRestoDetail)
//            val img: ImageView = requireView().findViewById(R.id.imgRestoDetail)
//            val progress: ProgressBar = requireView().findViewById(R.id.progressRestoDetail)
//
//            txtRelativeLoc.text = it.relativeLocation
//            txtRestoName.text = it.name
//            txtLoc.text = it.location
//            txtRating.text = it.rating.toString() + " - " + it.countReviews + " reviews"
//            txtOpenHours.text = it.openHour + " - " + it.closeHour
//
//            btnReviews.setOnClickListener { it1 ->
////                val action = RestoDetailFragmentDirections.actionReviewFromDetail(it.id)
////                Navigation.findNavController(it1).navigate(action)
//            }
//
//            fabCart.setOnClickListener { it2 ->
////                val action = RestoDetailFragmentDirections.actionCart(it.name, it.id)
////                Navigation.findNavController(it2).navigate(action)
//            }
//
//            img.loadImage(it.imageUrl, progress)
            dataBinding.resto = it
        })

        restoDetailViewModel.menuLD.observe(viewLifecycleOwner, Observer {
            menuAdapter.updateMenuList(it)
        })

        /*restoDetailViewModel.menuBestSellerLD.observe(viewLifecycleOwner, Observer {
            menuBestSellerHorizontalAdapter.updateMenuList(it)
        })*/
    }

    override fun onButtonDetailClick(v: View) {
        Toast.makeText(context, "halooo", Toast.LENGTH_SHORT).show()
        val action = RestoDetailFragmentDirections.actionReviewFromDetail(v.tag.toString().toInt())
        Navigation.findNavController(v).navigate(action)
    }

    override fun onFabCartClick(v: View, resto: Resto) {
        val action = RestoDetailFragmentDirections.actionCart(resto.name, resto.uuid)
        Navigation.findNavController(v).navigate(action)
    }

}