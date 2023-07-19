package com.yeet.anmp160420011midterm.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.model.User
import com.yeet.anmp160420011midterm.viewmodel.UserViewModel

class RegisterFragment : Fragment() {
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val btnRegis = view.findViewById<Button>(R.id.btnRegisterRegisterFragment)
        btnRegis.setOnClickListener {
            onRegisterClick(view)
        }
    }

    private fun onRegisterClick(v: View) {
        val user = User("ab", "", "", "")
        viewModel.checkUsernameAvailable(user.username)
        observe(user, v)
    }

    private fun observe(user: User, v: View) {
        viewModel.userLD.observe(viewLifecycleOwner, Observer {
            if (it == null) {
                viewModel.register(user)

                val action = RegisterFragmentDirections.actionLoginAfterRegister()
                Navigation.findNavController(v).navigate(action)
            } else {
                Toast.makeText(context, "Username is already taken. Please use another", Toast.LENGTH_SHORT).show()
            }
        })
    }
}