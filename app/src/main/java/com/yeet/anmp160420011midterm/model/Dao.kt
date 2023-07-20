package com.yeet.anmp160420011midterm.model

import androidx.room.Query
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.*

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //fun insertOrder(vararg order: Order)
    //fun insertResto(vararg resto: Resto)
    //fun insertBanner(vararg banner: Banner)
    //fun insertReview(vararg review: Review)
    fun insertMenu(vararg menu: Menu)
    //fun insertCart(vararg cart: Cart)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg user: User)

    @Query("SELECT * FROM banner")
    fun selectAllBanner(): List<Banner>

    @Query("SELECT * FROM resto")
    fun selectAllResto(): List<Resto>

    @Query("SELECT * FROM resto WHERE uuid = :id")
    fun selectResto(id:Int): Resto

    @Query("SELECT * FROM user WHERE username=:username AND pass=:pass")
    fun login(username:String, pass:String): User

    @Query("SELECT * FROM review WHERE uuid=:id")
    fun selectReview(id:Int): Review
    @Query("SELECT * FROM user WHERE username=:username")
    fun checkUsernameAvailable(username: String): User

    @Query("UPDATE user SET display_name=:display_name WHERE uuid=:id")
    fun updateName(display_name: String, id: Int)

    @Query("UPDATE user SET pass=:new_password WHERE uuid=:id")
    fun updatePassword(new_password: String, id: Int)

    @Query("SELECT * FROM menu ORDER BY uuid DESC LIMIT 10")
    fun selectNewestMenusAndResto(): List<Menu>

    @Query("SELECT * FROM `order` WHERE user_id=:user_id")
    fun getOrders(user_id: Int): List<Order>

    @Query("SELECT * FROM `user` WHERE uuid=:user_id")
    fun getUser(user_id: Int): User
}