package com.yeet.anmp160420011midterm.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.room.Room
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.model.CulinDatabase
import java.text.NumberFormat
import java.util.*

val DB_NAME = "newculindb"
fun buildDb(context: Context): CulinDatabase {
    val db = Room.databaseBuilder(context, CulinDatabase::class.java, DB_NAME)
        .build()
    return db
}

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