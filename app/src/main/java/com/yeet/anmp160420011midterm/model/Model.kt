package com.yeet.anmp160420011midterm.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class Order(
    @ColumnInfo(name = "resto_name")
    val restoName: String,
    @ColumnInfo(name = "count_items")
    val countItems: Int,
    @ColumnInfo(name = "items")
    val items: String,
    @ColumnInfo(name = "total_price")
    val totalPrice: Int,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "status")
    val status: String,
    @ColumnInfo(name = "address")
    val address: String,
    @ColumnInfo(name = "user_id")
    val userId: String,
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}

@Entity
data class Resto(
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
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}

@Entity
data class Banner(
    @ColumnInfo(name = "banner_link")
    val bannerLink: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "sponsor")
    val sponsor: String,
    @ColumnInfo(name = "restoId")
    val restoId: Int
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}

@Entity
data class Review(
    @ColumnInfo(name="user_name")
    val userName: String,
    @ColumnInfo(name = "user_profilepic_url")
    val profilePicUrl: String,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "rating")
    val rating: Float,
    @ColumnInfo(name = "date")
    val date: String,

){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}

@Entity
data class Menu(
    @ColumnInfo(name = "menu_name")
    val name: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "price")
    val price: Int,
    @ColumnInfo(name = "menu_img")
    val imgUrl: String,
    @ColumnInfo(name = "desc")
    val desc: String,
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}

@Entity
data class Cart(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "price")
    val price: Int,
    @ColumnInfo(name = "amount")
    val amount: Int
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}

@Entity
data class User(
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "pass")
    val pass: String,
    @ColumnInfo(name = "display_name")
    val displayName: String,
    @ColumnInfo(name = "profile_url")
    val profileUrl: String,
    @ColumnInfo(name = "balance")
    var balance: Int
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}

//data class MenuAndResto(
//    @Embedded val menu: Menu,
//    @Relation(
//        parentColumn = "uuid",
//        entityColumn = "uuid"
//    )
//)