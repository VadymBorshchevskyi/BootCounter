package com.example.bootcounter.repo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bootcounter.repo.db.dao.BootDao
import com.example.bootcounter.repo.db.model.DbBoot

private const val FILE_NAME: String = "main.db"

@Database(
    entities = [DbBoot::class],
    version = 1
)
abstract class Db : RoomDatabase() {
    abstract val bootDao: BootDao
}

fun Db(appContext: Context): Db =
    Room
        .databaseBuilder(appContext, Db::class.java, FILE_NAME)
        .fallbackToDestructiveMigration()
        .build()