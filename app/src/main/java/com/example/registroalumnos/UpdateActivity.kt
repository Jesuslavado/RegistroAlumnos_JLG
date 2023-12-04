package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registroalumnos.R
import com.example.registroalumnos.database.ActivitywhitMenus
import com.example.registroalumnos.database.MiResgistroApp
import com.example.registroalumnos.database.RegistrarAlumno
import com.example.registroalumnos.databinding.ActivityMainBinding
import com.example.registroalumnos.databinding.ActivityUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateActivity : ActivitywhitMenus() {
lateinit var binding: ActivityUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_update)

        binding.bactualizar.setOnClickListener {
            updateLista(
                RegistrarAlumno(
                    nombre = binding.nalumno.text.toString() ,
                    curso = binding.nuevocurso.text.toString()
                )
            )
        }
    }
    fun updateLista(RegistrarAlumno:RegistrarAlumno){
        CoroutineScope(Dispatchers.IO).launch {
            val n= RegistrarAlumno.nombre
            val recoveryalumno= MiResgistroApp.database.ResgistroDao().getElementoId(n)
            recoveryalumno.curso=binding.nuevocurso.text.toString()
            MiResgistroApp.database.ResgistroDao().updateLista(recoveryalumno)
        }
    }
    }
