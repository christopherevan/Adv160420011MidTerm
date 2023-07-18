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
import com.yeet.anmp160420011midterm.model.Banner
import com.yeet.anmp160420011midterm.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class BannerViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val bannersLD = MutableLiveData<ArrayList<Banner>>()
    val bannerLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private val job = Job()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun fetch() {
        launch {
            val db = buildDb(getApplication())
        }
        /*loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://wheli.site/adv/get_banners.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<Banner>>() {}.type
                val result = Gson().fromJson<ArrayList<Banner>>(it, sType)
                bannersLD.value = result
                loadingLD.value = false

                Log.d("showvoley", result.toString())

            },
            {
                Log.d("showvoley", it.toString())
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)*/
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO
}