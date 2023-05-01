package com.yeet.anmp160420011midterm.model

import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("order_id")
    val id: Int,
    @SerializedName("resto_name")
    val restoName: String,
    @SerializedName("count_items")
    val countItems: Int,
    val items: ArrayList<String>,
    @SerializedName("total_price")
    val totalPrice: Int,
    val date: String,
    val status: String
)

data class Resto(
    val id: Int,
    val name: String,
    @SerializedName("relative_location")
    val relativeLocation: String,
    val location: String,
    @SerializedName("open_hour")
    val openHour: String,
    @SerializedName("close_hour")
    val closeHour: String,
    @SerializedName("image_url")
    val imageUrl: String,
    val rating: Float,
    @SerializedName("count_reviews")
    val countReviews: Int
)

data class Banner(
    val id: Int,
    @SerializedName("banner_link")
    val bannerLink: String,
    val title: String,
    val sponsor: String
)

data class Review(
    val id: Int,
    @SerializedName("user_name")
    val userName: String,
    @SerializedName("user_profilepic_url")
    val profilePicUrl: String,
    val content: String,
    val rating: Float,
    val date: String
)

data class Menu(
    val id: Int,
    @SerializedName("menu_name")
    val name: String,
    val price: Int,
    @SerializedName("menu_img")
    val imgUrl: String,
    val desc: String
)

data class Cart(
    val id: Int,
    val name: String,
    val price: Int,
    val amount: Int
)

data class User(
    val username: String,
    @SerializedName("display_name")
    val displayName: String,
    @SerializedName("profile_url")
    val profileUrl: String
)