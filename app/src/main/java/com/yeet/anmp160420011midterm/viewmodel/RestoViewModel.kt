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
import com.yeet.anmp160420011midterm.model.Resto

class RestoViewModel(application: Application): AndroidViewModel(application) {
    val restoLD = MutableLiveData<ArrayList<Resto>>()
    val restoLD2 = MutableLiveData<ArrayList<Resto>>()
    val restoLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun fetch() {
        loadingLD.value = true
        restoLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://scheday.site/resto_get.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<Resto>>() { }.type
                val result = Gson().fromJson<ArrayList<Resto>>(it, sType)
                restoLD.value = result
                loadingLD.value = false

                Log.d("showvoley", result.toString())

            },
            {
                restoLoadErrorLD.value = true
                Log.d("showvoley", it.toString())
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun fetch_saved() {
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://scheday.site/get_user_saved.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<Resto>>() { }.type
                val result = Gson().fromJson<ArrayList<Resto>>(it, sType)
                restoLD.value = result
                loadingLD.value = false

                Log.d("showvoley", result.toString())

            },
            {
                Log.d("showvoley", it.toString())
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun fetch_home_horizontal() {
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://scheday.site/get_home_restos.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<Resto>>() { }.type
                val result = Gson().fromJson<ArrayList<Resto>>(it, sType)
                restoLD.value = result
                loadingLD.value = false

                Log.d("showvoley", result.toString())

            },
            {
                Log.d("showvoley", it.toString())
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    fun fetch_home_vertical() {
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://scheday.site/get_home_restos.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<Resto>>() { }.type
                val result = Gson().fromJson<ArrayList<Resto>>(it, sType)
                restoLD2.value = result

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