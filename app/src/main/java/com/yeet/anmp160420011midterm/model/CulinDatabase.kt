package com.yeet.anmp160420011midterm.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Order::class, Resto::class, Banner::class, Review::class, Menu::class, Cart::class, User::class), version = 1)
abstract class CulinDatabase:RoomDatabase() {
    abstract fun dao(): Dao

    companion object{
        @Volatile private var instance:CulinDatabase ?= null
        private val Lock = Any()

        private fun buildDatabase(context:Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CulinDatabase::class.java,
                "newtododb").build()

        operator fun invoke(context:Context) {
            if(instance!=null) {
                synchronized(Lock) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }

    }
}