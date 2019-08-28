package com.shs.date

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shs.date.dao.EventDao
import com.shs.date.model.Event

@Database(entities = arrayOf(Event::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao

    companion object {
        private var db: AppDatabase? = null
        fun getInstances(applicationContext: Context): AppDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java, "date-database"
                ).build()
            }

            return db!!
        }
    }
}