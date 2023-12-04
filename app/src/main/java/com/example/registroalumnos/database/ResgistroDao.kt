package com.example.registroalumnos.database
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ResgistroDao {
    @Query("SELECT * FROM registrar_alumno")
    fun getAllElements(): MutableList<RegistrarAlumno>

    @Insert
    fun addElemnento(RegistrarAlumno: RegistrarAlumno)


    @Query("SELECT * FROM registrar_alumno WHERE nombre = :nombre")
    fun getElementoId(nombre:String):RegistrarAlumno

    @Update
    fun updateLista(RegistrarAlumno: RegistrarAlumno)

    @Delete
    fun deleteLista(RegistrarAlumno: RegistrarAlumno)
}