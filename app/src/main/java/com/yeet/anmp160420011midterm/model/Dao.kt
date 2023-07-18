package com.yeet.anmp160420011midterm.model

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.*

@androidx.room.Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrder(vararg order: Order)
    fun insertResto(vararg resto: Resto)
    fun insertBanner(vararg banner: Banner)
    fun insertReview(vararg review: Review)
    fun insertMenu(vararg menu: Menu)
    fun insertCart(vararg cart: Cart)
    fun insertUser(vararg user: User)


}