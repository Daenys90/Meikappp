package com.example.meikapp.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ProductEntity::class], version = 1)
@TypeConverters(TagListTypeConverter::class)
abstract class MakeUpDatabase : RoomDatabase() {

    abstract fun getMakeUpDao(): MakeUpDao

    companion object {
        @Volatile
        private var INSTANCE: MakeUpDatabase? = null

        fun getDatabase(context: Context): MakeUpDatabase{
            val tempInstance: MakeUpDatabase? =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance: MakeUpDatabase = Room.databaseBuilder(
                    context.applicationContext,
                    MakeUpDatabase::class.java,
                    "product_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }
}
