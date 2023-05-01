package com.yeet.anmp160420011midterm.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.util.loadImage
import com.yeet.anmp160420011midterm.viewmodel.UserViewModel

class ProfileFragment : Fragment() {
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val username = "johndoe369"

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.fetch(username)
        
        observe()
    }

    @SuppressLint("SetTextI18n")
    private fun observe() {
        viewModel.userLD.observe(viewLifecycleOwner, Observer {
            val img: ImageView = requireView().findViewById(R.id.imgUserProfile)
            val txtUsername: TextView = requireView().findViewById(R.id.txtUsernameProfile)
            val txtDispName: TextInputEditText = requireView().findViewById(R.id.txtDispNameProfile)
            val pb: ProgressBar = requireView().findViewById(R.id.progressBar)
            val btn: Button = requireView().findViewById(R.id.btnUpdate)

            img.loadImage(it.profileUrl, pb)
            txtUsername.text = "Username: ${it.username}"
            txtDispName.setText(it.displayName)
            
            btn.setOnClickListener {
                Toast.makeText(context, "Feature not yet implemented", Toast.LENGTH_SHORT).show()
            }
        })
    }
}