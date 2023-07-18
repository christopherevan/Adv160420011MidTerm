package com.yeet.anmp160420011midterm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.yeet.anmp160420011midterm.R

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    fun onRegisterClick(v: View) {
        val action = WelcomeFragmentDirections.actionRegistFragment()
        Navigation.findNavController(v).navigate(action)
    }

    fun onLoginClick(v: View) {
        val action = WelcomeFragmentDirections.actionLoginFragment()
        Navigation.findNavController(v).navigate(action)
    }
}