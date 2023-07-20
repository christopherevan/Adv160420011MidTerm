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
import com.yeet.anmp160420011midterm.model.Order
import com.yeet.anmp160420011midterm.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class OrderViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val ordersLD = MutableLiveData<List<Order>>()
    val orderLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun fetch(id: Int) {
        loadingLD.value = true

//        queue = Volley.newRequestQueue(getApplication())
//        val url = "http://wheli.site/adv/get_user_orders.php"
//
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            {
//                val sType = object : TypeToken<ArrayList<Order>>() { }.type
//                val result = Gson().fromJson<ArrayList<Order>>(it, sType)
//                ordersLD.value = result
//                loadingLD.value = false
//
//                Log.d("showvoley", result.toString())
//
//            },
//            {
//                Log.d("showvoley", it.toString())
//            }
//        )
//
//        stringRequest.tag = TAG
//        queue?.add(stringRequest)
        launch {
            val db = buildDb(getApplication())
            val orders = db.dao().getOrders(id)
            ordersLD.postValue(orders)
        }
    }
}