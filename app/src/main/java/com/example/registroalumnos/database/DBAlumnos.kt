package com.example.registroalumnos.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(RegistrarAlumno::class), version = 1)
abstract class DBAlumnos : RoomDatabase() {
    abstract fun ResgistroDao():ResgistroDao
}