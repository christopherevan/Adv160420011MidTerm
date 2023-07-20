package com.yeet.anmp160420011midterm.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.databinding.FragmentRegisterBinding
import com.yeet.anmp160420011midterm.model.User
import com.yeet.anmp160420011midterm.viewmodel.UserViewModel

class RegisterFragment : Fragment(), ButtonRegisterClickListener {
    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        dataBinding.register = viewModel
        dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        dataBinding.btnRegisterRegisterFragment.setOnClickListener {

        }
    }

//    private fun onRegisterClick(user: User, v: View) {
//        viewModel.checkUsernameAvailable(user.username)
//        observe(user, v)
//    }

    private fun observe(user: User, v: View) {
        viewModel.userLD.observe(viewLifecycleOwner, Observer {
            if (it == null) {
                viewModel.register(user)
                Toast.makeText(context, "Register successful. Please log in", Toast.LENGTH_SHORT).show()
                val action = RegisterFragmentDirections.actionLoginAfterRegister()
                Navigation.findNavController(v).navigate(action)
            } else {
                Toast.makeText(context, "Username is already taken. Please use another", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onButtonRegisterClick(v: View, user: User) {
        viewModel.checkUsernameAvailable(user.username)
        observe(user, v)
    }
}