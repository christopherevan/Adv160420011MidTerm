package com.yeet.anmp160420011midterm.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yeet.anmp160420011midterm.model.User
import com.yeet.anmp160420011midterm.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val userLD = MutableLiveData<User?>()
    val userLoadErrLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val profileLD = MutableLiveData<User>()
    val oldPassword = MutableLiveData<String>()
    val newPassword = MutableLiveData<String>()
    var displayName = MutableLiveData<String>()
    val usernameRegister = MutableLiveData<String>()
    val passwordRegister = MutableLiveData<String>()
    val passwordRepeatRegister = MutableLiveData<String>()
    val nameRegister = MutableLiveData<String>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

//    fun fetch(unm: String) {
//        queue = Volley.newRequestQueue(getApplication())
//        val url = "http://wheli.site/adv/get_user.php?username=$unm"
//
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            {
//                val sType = object : TypeToken<User>() {}.type
//                val result = Gson().fromJson<User>(it, sType)
//                userLD.value = result
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
//    }

    fun login(username: String, password: String) {
        launch {
            val db = buildDb(getApplication())
            val user = db.dao().login(username, password)
            userLD.postValue(user)
        }
    }

    fun methodRegister(){
        val balance = 350000
        val user = User(usernameRegister.value.toString(), passwordRegister.value.toString(), passwordRepeatRegister.value.toString(), nameRegister.value.toString(), balance)
        register(user)
    }

    fun register(user: User) {
        launch {
//            if (!usernameValue.isNullOrEmpty() && !passwordValue.isNullOrEmpty() && !nameValue.isNullOrEmpty() && !passwordRepeatValue.isNullOrEmpty()){
            val db = buildDb(getApplication())
            db.dao().insertUser(user)
//            }
        }
    }

    fun checkUsernameAvailable(username: String) {
        launch {
            val db = buildDb(getApplication())
            val user = db.dao().checkUsernameAvailable(username)
            userLD.postValue(user)
        }
    }

    fun updateName(name: String, id: Int) {
        launch {
            val db = buildDb(getApplication())
            db.dao().updateName(name, id)
        }
    }

    fun resetPassword(newPass: String, id: Int) {
        launch {
            val db = buildDb(getApplication())
            db.dao().updatePassword(newPass, id)
        }
    }

    fun getUser(id: Int){
        launch {
            val db = buildDb(getApplication())
            val user = db.dao().getUser(id)
            profileLD.postValue(user)
        }
    }
}