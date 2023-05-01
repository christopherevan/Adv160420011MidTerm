package com.yeet.anmp160420011midterm.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.yeet.anmp160420011midterm.R
import java.text.NumberFormat
import java.util.*

fun ImageView.loadImage(url: String?, progressBar: ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.baseline_error_24)
        .into(this, object: Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }
            override fun onError(e: Exception?) {
            }
        })
}

fun String.toCurrencyFormat(): String {
    val localeID = Locale("in", "ID")
    val doubleValue = this.toDoubleOrNull() ?: return this
    val numberFormat = NumberFormat.getCurrencyInstance(localeID)
    numberFormat.minimumFractionDigits = 0
    return numberFormat.format(doubleValue)
}