package com.sournary.awesomeenglish.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sournary.awesomeenglish.model.EVWord

/**
 * Created by fs-sournary.
 * Date: 10/28/18.
 * Description:
 */
@Database(entities = [EVWord::class], version = EVDb.EV_DB_VERSION)
abstract class EVDb : RoomDatabase() {

    abstract fun getEVDao(): EVDao

    companion object {

        const val EV_DB_VERSION = 1
        private const val EV_DB_NAME = "awesome-english"

        fun getInstance(context: Context): EVDb =
            Room.databaseBuilder(context, EVDb::class.java, EV_DB_NAME)
                .fallbackToDestructiveMigration().build()
    }
}
