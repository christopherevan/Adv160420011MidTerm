package com.yeet.anmp160420011midterm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Order(
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0,
    @ColumnInfo(name = "resto_name")
    val restoName: String,
    @ColumnInfo(name = "count_items")
    val countItems: Int,
    @ColumnInfo(name = "items")
    val items: ArrayList<String>,
    @ColumnInfo(name = "total_price")
    val totalPrice: Int,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "status")
    val status: String,
)

data class Resto(
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "relative_location")
    val relativeLocation: String,
    @ColumnInfo(name = "location")
    val location: String,
    @ColumnInfo(name = "open_hour")
    val openHour: String,
    @ColumnInfo(name = "close_hour")
    val closeHour: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "rating")
    val rating: Float,
    @ColumnInfo(name = "count_reviews")
    val countReviews: Int
)

data class Banner(
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0,
    @ColumnInfo(name = "banner_link")
    val bannerLink: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "sponsor")
    val sponsor: String
)

data class Review(
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0,
    @ColumnInfo(name="user_name")
    val userName: String,
    @ColumnInfo(name = "user_profilepic_url")
    val profilePicUrl: String,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "rating")
    val rating: Float,
    @ColumnInfo(name = "date")
    val date: String
)

data class Menu(
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0,
    @ColumnInfo(name = "menu_name")
    val name: String,
    @ColumnInfo(name = "price")
    val price: Int,
    @ColumnInfo(name = "menu_img")
    val imgUrl: String,
    @ColumnInfo(name = "desc")
    val desc: String
)

data class Cart(
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "price")
    val price: Int,
    @ColumnInfo(name = "amount")
    val amount: Int
)

data class User(
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "display_name")
    val displayName: String,
    @ColumnInfo(name = "profile_url")
    val profileUrl: String
)