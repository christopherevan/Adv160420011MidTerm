package com.yeet.anmp160420011midterm.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yeet.anmp160420011midterm.model.Menu
import com.yeet.anmp160420011midterm.model.Resto

class RestoDetailViewModel(application: Application): AndroidViewModel(application) {
    val restoLD = MutableLiveData<Resto>()
    val menuBestSellerLD = MutableLiveData<ArrayList<Menu>>()
    val menuLD = MutableLiveData<ArrayList<Menu>>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun fetchResto(id: Int) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://wheli.site/adv/get_resto_detail.php?resto_id=$id"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<Resto>() { }.type
                val result = Gson().fromJson<Resto>(it, sType)
                restoLD.value = result

                Log.d("showvoley", result.toString())

            },
            {
                Log.d("showvoley", it.toString())
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun fetchMenu(id: Int) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://wheli.site/adv/get_menu.php?resto_id=$id"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<Menu>>() { }.type
                val result = Gson().fromJson<ArrayList<Menu>>(it, sType)
                menuLD.value = result

                Log.d("showvoley", result.toString())

            },
            {
                Log.d("showvoley", it.toString())
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun fetchMenuBestSeller(id: Int) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://wheli.site/adv/get_bestseller.php?resto_id=$id"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<Menu>>() { }.type
                val result = Gson().fromJson<ArrayList<Menu>>(it, sType)
                menuBestSellerLD.value = result

                Log.d("showvoley", result.toString())

            },
            {
                Log.d("showvoley", it.toString())
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}