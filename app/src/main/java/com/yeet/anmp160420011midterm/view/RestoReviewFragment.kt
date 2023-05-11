package com.yeet.anmp160420011midterm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.viewmodel.ReviewViewModel

class RestoReviewFragment : Fragment() {
    private lateinit var viewModel: ReviewViewModel
    private val reviewAdapter = ReviewAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resto_review, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (arguments != null) {
            val id = RestoReviewFragmentArgs.fromBundle(requireArguments()).restoId

            viewModel = ViewModelProvider(this).get(ReviewViewModel::class.java)
            viewModel.fetch(id)

            val rv: RecyclerView = view.findViewById(R.id.rvReviews)
            rv.layoutManager = LinearLayoutManager(context)
            rv.adapter = reviewAdapter
            observe()
        }
    }

    private fun observe() {
        viewModel.reviewsLD.observe(viewLifecycleOwner, Observer {
            reviewAdapter.updateReviewList(it)
        })
        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            val pb: ProgressBar = requireView().findViewById(R.id.progressRvReview)

            if (it == true) {
                pb.visibility = View.VISIBLE
            } else {
                pb.visibility = View.GONE
            }
        })
    }
}