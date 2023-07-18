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

class MenuViewModel(application: Application): AndroidViewModel(application) {
    val menuLD = MutableLiveData<Menu>()
    val menuLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun fetch(id: Int) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://wheli.site/adv/get_menu_detail.php?menu_id=$id"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<Menu>() { }.type
                val result = Gson().fromJson<Menu>(it, sType)
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
}