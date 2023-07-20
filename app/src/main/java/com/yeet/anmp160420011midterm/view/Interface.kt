package com.yeet.anmp160420011midterm.view

import android.view.View
import com.yeet.anmp160420011midterm.model.User

interface FragmentHomeLayoutInterface {
    fun onTopupClick()
}

interface ButtonDetailClickListener {
    fun onButtonDetailClick(v: View)
}

interface ButtonBannerClickListener {
    fun onButtonBannerClick(v: View)
}

interface ButtonUserEditClickListener{
    fun onButtonUserEditClick(v:View)
}

interface ButtonRegisterClickListener{
    fun onButtonRegisterClick(v:View, obj:User)
}
