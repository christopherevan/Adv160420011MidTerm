package com.yeet.anmp160420011midterm.model

import android.content.Context
import android.provider.ContactsContract.Data
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock


@androidx.room.Database(entities = arrayOf(Order::class, Resto::class, Banner::class, Review::class, Menu::class, Cart::class, User::class), version = 1)
abstract class Database:RoomDatabase() {
    abstract fun dao(): Dao

    companion object{
        @Volatile private var instance:Database ?= null
        private val Lock = Any()

        private fun buildDatabase(context:Context) =
            Room.databaseBuilder(
                context.applicationContext,
                Database::class.java,
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