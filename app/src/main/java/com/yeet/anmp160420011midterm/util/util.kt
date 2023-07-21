package com.yeet.anmp160420011midterm.util

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.google.android.material.internal.TextWatcherAdapter
import com.google.android.material.textfield.TextInputEditText
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.yeet.anmp160420011midterm.R
import com.yeet.anmp160420011midterm.model.CulinDatabase
import java.text.NumberFormat
import java.util.*

val DB_NAME = "newculindb7"
fun buildDb(context: Context): CulinDatabase {
    val db = Room.databaseBuilder(context, CulinDatabase::class.java, DB_NAME)
        .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
        .build()
    return db
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE Menu ADD COLUMN resto_id INTEGER DEFAULT 0 not null")
    }
}

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE Review ADD COLUMN resto_id INTEGER DEFAULT 0 not null") //is_done field use integer instead of boolean because SQLite doesn't have a separate boolean storage class. Boolean values are stored as integers (0 or 1).
    }
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

@BindingAdapter("android:imageUrl", "android:progressBar")
fun loadPhotoURL(view: ImageView, url: String, pb: ProgressBar) {
    view.loadImage(url, pb)
}

@BindingAdapter("app:text")
fun setText(view: TextInputEditText, value: String?) {
    if (view.text.toString() != value) {
        view.setText(value)
    }
}

@InverseBindingAdapter(attribute = "app:text")
fun getText(view: TextInputEditText): String {
    return view.text.toString()
}

@BindingAdapter("app:textAttrChanged")
fun setListener(view: TextInputEditText, listener: InverseBindingListener?) {
    view.addTextChangedListener(@SuppressLint("RestrictedApi")
    object : TextWatcherAdapter() {
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            listener?.onChange()
        }
    })
}