package com.slient.jobhelp.models.database.dbhelper

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.slient.jobhelp.models.database.dao.GroupQuestionDAO
import com.slient.jobhelp.models.database.dao.QuestionDAO
import com.slient.jobhelp.models.database.data.GroupQuestion
import com.slient.jobhelp.models.database.data.Question

/**
 * Created by silent on 5/3/2018.
 */
@Database(entities = [(GroupQuestion::class), (Question::class)], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun questionDAO(): QuestionDAO
    abstract fun groupQuestionDAO(): GroupQuestionDAO

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if(INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java, "john-holland-db")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}