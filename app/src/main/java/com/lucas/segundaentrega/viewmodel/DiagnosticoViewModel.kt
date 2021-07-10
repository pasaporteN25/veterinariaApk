package com.lucas.segundaentrega.viewmodel

import androidx.lifecycle.ViewModel
import com.lucas.segundaentrega.dao.DBgestor
import android.content.Context
import com.lucas.segundaentrega.model.Diagnostico
import kotlin.coroutines.coroutineContext

class DiagnosticoViewModel : ViewModel(){

    fun saveDiagnostico( nombre:String, resultado:String, causas:String, medicamentos:String, context:Context):Boolean{
        val db: DBgestor = DBgestor(context,null)
        return db.saveDiagnostico(Diagnostico(nombre,resultado,causas,medicamentos))
    }
}