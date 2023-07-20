package com.yeet.anmp160420011midterm.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yeet.anmp160420011midterm.model.CulinDatabase
import com.yeet.anmp160420011midterm.model.Menu
import com.yeet.anmp160420011midterm.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MenuViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val menuLD = MutableLiveData<Menu>()
    val menusLD = MutableLiveData<List<Menu>>()
    val menuLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    private var job = Job()

    fun refresh() {
        loadingLD.value = true
        menuLoadErrorLD.value = false
        launch {
//            val db = Room.databaseBuilder(
//                getApplication(),
//                CulinDatabase::class.java, "newculindb4").build()
            val db = buildDb(getApplication())

            menusLD.postValue(db.dao().selectNewestMenusAndResto())
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun fetch(id: Int) {
//        queue = Volley.newRequestQueue(getApplication())
//        val url = "http://wheli.site/adv/get_menu_detail.php?menu_id=$id"
//
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            {
//                val sType = object : TypeToken<Menu>() { }.type
//                val result = Gson().fromJson<Menu>(it, sType)
//                menuLD.value = result
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
    }

    fun fetchNewestMenus() {
//        launch {
//            val db = buildDb(getApplication())
//            val menus: List<Menu> = db.dao().selectNewestMenus()
//            menusLD.postValue(menus)
//        }
    }
}