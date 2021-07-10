package com.lucas.segundaentrega.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.lucas.segundaentrega.dao.DBgestor
import com.lucas.segundaentrega.model.Paciente

class PacienteViewModel: ViewModel() {

    fun guardarPaciente(nombre:String, tipo:String, raza:String, edad:String, causa:String, medico:String, context: Context):Boolean{

        val db:DBgestor = DBgestor(context,null)
        return db.saveConsulta(Paciente(0, nombre, tipo, raza, edad, causa, medico))
    }

    fun getPacientes(context: Context, name:String):ArrayList<Paciente>{
        val db: DBgestor = DBgestor(context,null)

        return db.getPacientes(name)

    }
}