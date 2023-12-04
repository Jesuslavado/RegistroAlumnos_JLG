package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.registroalumnos.R
import com.example.registroalumnos.database.ActivitywhitMenus
import com.example.registroalumnos.database.MiResgistroApp
import com.example.registroalumnos.database.RegistrarAlumno
import com.example.registroalumnos.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ActivitywhitMenus() {
    lateinit var binding : ActivityMainBinding
    lateinit var elementos: MutableList<RegistrarAlumno>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.baAdir.setOnClickListener{
            val nombre = binding.nombre.text.toString()
            val apellidos = binding.apellidos.text.toString()
            val curso = binding.curso.text.toString()

            addElemnento(RegistrarAlumno(nombre = nombre, apellidos = apellidos, curso = curso))
        }
    }
fun addElemnento(RegistrarAlumno:RegistrarAlumno)
{
    CoroutineScope(Dispatchers.IO).launch {
        MiResgistroApp.database.ResgistroDao().addElemnento(RegistrarAlumno)
    }
}


}

