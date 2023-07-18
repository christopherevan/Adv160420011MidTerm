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
import com.yeet.anmp160420011midterm.model.User

class UserViewModel(application: Application): AndroidViewModel(application) {
    val userLD = MutableLiveData<User>()
    val userLoadErrLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun fetch(unm: String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://wheli.site/adv/get_user.php?username=$unm"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<User>() {}.type
                val result = Gson().fromJson<User>(it, sType)
                userLD.value = result

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