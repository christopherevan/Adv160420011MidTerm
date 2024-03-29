package com.yeet.anmp160420011midterm.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.databinding.FragmentHomeBinding
import com.yeet.anmp160420011midterm.databinding.FragmentProfileBinding
import com.yeet.anmp160420011midterm.model.Global
import com.yeet.anmp160420011midterm.util.NotificationHelper
import com.yeet.anmp160420011midterm.util.OrderWorker
import com.yeet.anmp160420011midterm.util.toCurrencyFormat
import com.yeet.anmp160420011midterm.viewmodel.BannerViewModel
import com.yeet.anmp160420011midterm.viewmodel.MenuViewModel
import com.yeet.anmp160420011midterm.viewmodel.RestoViewModel
import com.yeet.anmp160420011midterm.viewmodel.UserViewModel
import java.util.concurrent.TimeUnit

class HomeFragment : Fragment() {
    private lateinit var bannerViewModel: BannerViewModel
    private val bannerAdapter = BannerAdapter(arrayListOf())
    private lateinit var dataBinding: FragmentHomeBinding

    private lateinit var userViewModel: UserViewModel

    /*private lateinit var homeRestoViewModel: RestoViewModel
    private val homeRestoAdapterV = HomeRestoAdapterVertical(arrayListOf())
    private val homeRestoAdapterH = HomeRestoAdapter(arrayListOf())*/

    private lateinit var menusViewModel: MenuViewModel
    private val menuAdapter = MenuAdapter(arrayListOf())

    private var loadingBannerLD = MutableLiveData<Boolean>()
    private var loadingRestoLD = MutableLiveData<Boolean>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)

        dataBinding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)
        return dataBinding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Global.cart.clear()
        val txtBalance: TextView = view.findViewById(R.id.txtBalanceHome)
        txtBalance.text = Global.userBalance.toString().toCurrencyFormat()

        bannerViewModel = ViewModelProvider(this).get(BannerViewModel::class.java)
        bannerViewModel.refresh()

//        val rvBanner: RecyclerView = view.findViewById(R.id.rvSponsored)
//        rvBanner.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        rvBanner.adapter = bannerAdapter

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val shared = context!!.getSharedPreferences(R.string.preference_file_key.toString(), Context.MODE_PRIVATE)
        val id = shared.getInt(R.string.user_id_key.toString(), 0)
        userViewModel.getUser(id)

        /*homeRestoViewModel = ViewModelProvider(this).get(RestoViewModel::class.java)
        homeRestoViewModel.fetch_home_horizontal()
        homeRestoViewModel.fetch_home_vertical()*/

        menusViewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        menusViewModel.refresh()



//        val rvForYou: RecyclerView = view.findViewById(R.id.rvForYou)
//        rvForYou.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        rvForYou.adapter = menuAdapter

        val rvForYouVertical: RecyclerView = view.findViewById(R.id.rvForYouVertical)
        val lm = object : LinearLayoutManager(context) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        rvForYouVertical.layoutManager = lm
        rvForYouVertical.adapter = menuAdapter

        val btnTopup: Button = view.findViewById(R.id.btnTopupHome)
        btnTopup.setOnClickListener {
            Toast.makeText(context, "Feature not yet implemented", Toast.LENGTH_SHORT).show()

        }
        
        observe()
    }

    private fun observe() {
//        val progressBanner: ProgressBar = requireView().findViewById(R.id.progressSponsored)
//        val div: View = requireView().findViewById(R.id.divider3)
//        val txtSponsored: TextView = requireView().findViewById(R.id.txtSponsored)
//        val txtFy: TextView = requireView().findViewById(R.id.txtFy)

        bannerViewModel.bannersLD.observe(viewLifecycleOwner, Observer {
            bannerAdapter.updateBannerList(it)
        })
        bannerViewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            loadingBannerLD.value = it != true
        })

//        homeRestoViewModel.restoLD.observe(viewLifecycleOwner, Observer {
//            homeRestoAdapterV.updateRestoList(it)
//        })
        menusViewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            loadingRestoLD.value = it != true
        })

        /*homeRestoViewModel.restoLD2.observe(viewLifecycleOwner, Observer {
            homeRestoAdapterH.updateRestoList(it)
        })*/


        menusViewModel.menusLD.observe(viewLifecycleOwner, Observer {
            menuAdapter.updateMenuList(it)
        })

        userViewModel.profileLD.observe(viewLifecycleOwner, Observer {
            dataBinding.user = it
        })
    }
}