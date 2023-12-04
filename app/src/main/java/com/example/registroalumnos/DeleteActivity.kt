package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registroalumnos.R
import com.example.registroalumnos.database.ActivitywhitMenus
import com.example.registroalumnos.database.MiResgistroApp
import com.example.registroalumnos.database.RegistrarAlumno
import com.example.registroalumnos.databinding.ActivityDeleteBinding
import com.example.registroalumnos.databinding.ActivityUpdateBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeleteActivity : ActivitywhitMenus() {
    lateinit var binding: ActivityDeleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_delete)

        binding.beliminar.setOnClickListener {
            deleteLista(
                RegistrarAlumno(
                    nombre = binding.neliminar.text.toString()
                )
            )
        }
    }

    fun deleteLista(RegistrarAlumno:RegistrarAlumno){
        CoroutineScope(Dispatchers.IO).launch {
            val n= RegistrarAlumno.nombre
            val recoveryalumno= MiResgistroApp.database.ResgistroDao().getElementoId(n)
            recoveryalumno.curso=binding.neliminar.text.toString()
            MiResgistroApp.database.ResgistroDao().updateLista(recoveryalumno)
        }
    }
}