package com.yeet.anmp160420011midterm.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.model.Global
import com.yeet.anmp160420011midterm.model.User
import com.yeet.anmp160420011midterm.viewmodel.UserViewModel

class LoginFragment : Fragment() {
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val user = User("ab", "", "", "", 0)
        val btnLogin = view.findViewById<Button>(R.id.btnLoginLoginFragment)
        btnLogin.setOnClickListener {
            onLoginClick(user.username, user.pass)
        }
    }

    fun onLoginClick(username: String, password: String) {
        viewModel.login(username, password)
        observe()
    }

    fun observe() {
        viewModel.userLD.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                val sharedPref = activity?.getSharedPreferences(R.string.preference_file_key.toString(), Context.MODE_PRIVATE)
                if (sharedPref != null) {
                    with (sharedPref.edit()) {
                        putString(R.string.username_key.toString(), it.username)
                        putInt(R.string.user_id_key.toString(), it.uuid)
                        apply()
                    }
                }

                Toast.makeText(context, "Welcome", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                activity?.finish()
            } else {
                Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        })
    }
}