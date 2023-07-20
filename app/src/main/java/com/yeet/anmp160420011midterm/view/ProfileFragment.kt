package com.yeet.anmp160420011midterm.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.databinding.FragmentProfileBindingImpl
import com.yeet.anmp160420011midterm.databinding.FragmentProfileBinding
import com.yeet.anmp160420011midterm.model.User
import com.yeet.anmp160420011midterm.util.loadImage
import com.yeet.anmp160420011midterm.viewmodel.UserViewModel

class ProfileFragment : Fragment() {
    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentProfileBinding>(inflater, R.layout.fragment_profile, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val username = "johndoe369"

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val btnlogout = view.findViewById<FloatingActionButton>(R.id.btnLogout)
        btnlogout.setOnClickListener {
            onLogoutClick()
        }
    //viewModel.fetch(username)
        
//        observe()
    }

    fun onLogoutClick() {
        val shared = activity?.getSharedPreferences(R.string.preference_file_key.toString(), Context.MODE_PRIVATE)
        if (shared != null) {
            with (shared.edit()) {
                remove(R.string.username_key.toString())
                clear()
                apply()
            }
        }

        Toast.makeText(context, "Logout success", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, WelcomeActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }

    fun onPasswordResetClick(password: String) {
        val shared = activity?.getSharedPreferences(R.string.preference_file_key.toString(), Context.MODE_PRIVATE)
        val username = shared?.getString(R.string.username_key.toString(), "")
        val id = shared?.getInt(R.string.user_id_key.toString(), 0)
        viewModel.login(username!!, password)

        observe(password)
    }

    fun onUpdateProfileClick(user: User) {
        viewModel.updateName(user.displayName, user.uuid)

        // Reload activity
        activity?.finish()
        startActivity(activity?.intent!!)
    }

    fun observe(password: String) {
        viewModel.userLD.observe(viewLifecycleOwner, Observer {
            dataBinding.profile = it
            /*if (it != null) {
                viewModel.resetPassword(password, id)
                Toast.makeText(context, "Reset password success. Please login again", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, WelcomeActivity::class.java)
                startActivity(intent)
                activity?.finish()
            } else {
                Toast.makeText(context, "Incorrect old password", Toast.LENGTH_SHORT).show()
            }*/
        })
    }
}