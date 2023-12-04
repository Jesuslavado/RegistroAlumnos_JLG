package com.example.registroalumnos.database
import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
class MiResgistroApp: Application() {
    companion object{
        lateinit var database: DBAlumnos
    }

    override fun onCreate() {
        super.onCreate()
        MiResgistroApp.database=Room.databaseBuilder(this,DBAlumnos::class.java,"DBAlumnos").build()
    }
}