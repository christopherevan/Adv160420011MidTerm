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
            val usernameValue = dataBinding.register?.usernameRegister?.value
            val passwordValue = dataBinding.register?.passwordRegister?.value
            val passwordRepeatValue = dataBinding.register?.passwordRepeatRegister?.value
            val nameValue = dataBinding.register?.nameRegister?.value

            if (!usernameValue.isNullOrEmpty()
                && !passwordValue.isNullOrEmpty()
                && !passwordRepeatValue.isNullOrEmpty()
                && !nameValue.isNullOrEmpty()
                && passwordValue == passwordRepeatValue
            ) {
                // Create a User object with entered data
                val user = User(usernameValue, passwordValue, nameValue)

                // Call the function to check if the username is available and register the user
                viewModel.checkUsernameAvailable(user.username)

                // Observe the userLD LiveData to determine if the registration was successful or not
                viewModel.userLD.observe(viewLifecycleOwner, Observer {
                    if (it == null) {
                        viewModel.register(user)
                        Toast.makeText(context, "Register successful. Please log in", Toast.LENGTH_SHORT).show()
                        val action = RegisterFragmentDirections.actionLoginAfterRegister()
                        Navigation.findNavController(view).navigate(action)
                    } else {
                        Toast.makeText(context, "Username is already taken. Please use another", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(context, "Please fill in all fields correctly", Toast.LENGTH_SHORT).show()
            }
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