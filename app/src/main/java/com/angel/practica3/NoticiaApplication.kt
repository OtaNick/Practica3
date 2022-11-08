package com.angel.practica3

import android.app.Application
import androidx.room.Room

class NoticiaApplication: Application() {
    companion object {
        lateinit var database: NoticiaDataBase
    }
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, NoticiaDataBase::class.java,
            "NoticiaDatabase").build()
    }
}