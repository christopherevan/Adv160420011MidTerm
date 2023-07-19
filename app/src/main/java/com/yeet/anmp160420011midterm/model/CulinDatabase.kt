package com.yeet.anmp160420011midterm.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yeet.anmp160420011midterm.util.MIGRATION_1_2
import com.yeet.anmp160420011midterm.util.MIGRATION_2_3

@Database(entities = arrayOf(Order::class, Resto::class, Banner::class, Review::class, Menu::class, Cart::class, User::class), version = 3)
abstract class CulinDatabase:RoomDatabase() {
    abstract fun dao(): Dao

    companion object{
        @Volatile private var instance:CulinDatabase ?= null
        private val Lock = Any()

        private fun buildDatabase(context:Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CulinDatabase::class.java,
                "newculindb").addMigrations(MIGRATION_1_2, MIGRATION_2_3).build()

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