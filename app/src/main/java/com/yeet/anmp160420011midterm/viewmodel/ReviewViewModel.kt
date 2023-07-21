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
import com.yeet.anmp160420011midterm.model.Review
import com.yeet.anmp160420011midterm.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ReviewViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val reviewsLD = MutableLiveData<List<Review>>()
    val reviewLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private val job = Job()

    fun refresh(uuid:Int) {
        loadingLD.value = true
        reviewLoadErrorLD.value = false
        launch {
//            val db = Room.databaseBuilder(
//                getApplication(),
//                CulinDatabase::class.java, "newculindb5").build()
            val db = buildDb(getApplication())

            reviewsLD.postValue(db.dao().selectReview(uuid))
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO
    /*val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun fetch(id: Int) {
        loadingLD.value = true
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://wheli.site/adv/get_reviews.php?resto_id=$id"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<Review>>() { }.type
                val result = Gson().fromJson<ArrayList<Review>>(it, sType)
                reviewsLD.value = result
                loadingLD.value = false

                Log.d("showvoley", result.toString())

            },
            {
                Log.d("showvoley", it.toString())
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }*/
}