package com.yeet.anmp160420011midterm.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.databinding.MenuItemBinding
import com.yeet.anmp160420011midterm.databinding.RestoReviewItemBinding
import com.yeet.anmp160420011midterm.model.Review
import com.yeet.anmp160420011midterm.util.loadImage

class ReviewAdapter(private val reviewList:ArrayList<Review>)
    : RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>()
{
    class ReviewViewHolder(var view: RestoReviewItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = RestoReviewItemBinding.inflate(inflater, parent, false)
        return ReviewViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.view.review = reviewList[position]
        /*val txtName: TextView = holder.view.findViewById(R.id.txtProfileNameReviewItem)
        val txtRating: TextView = holder.view.findViewById(R.id.txtRatingReviewItem)
        val txtComment: TextView = holder.view.findViewById(R.id.txtCommentReviewItem)
        val img: ImageView = holder.view.findViewById(R.id.imgProfileReviewItem)
        val progressBar: ProgressBar = holder.view.findViewById(R.id.progressReview)

        txtName.text = reviewList[position].userName
        txtRating.text = reviewList[position].rating.toString() + " - " + reviewList[position].date
        txtComment.text = reviewList[position].content

        img.loadImage(reviewList[position].profilePicUrl, progressBar)*/
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }

    fun updateReviewList(newReviewList: List<Review>) {
        reviewList.clear()
        reviewList.addAll(newReviewList)
        notifyDataSetChanged()
    }
}
