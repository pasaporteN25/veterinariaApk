package com.lucas.segundaentrega.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.lucas.segundaentrega.dao.DBgestor
import com.lucas.segundaentrega.model.Paciente

class RankingViewModel : ViewModel(){

    fun getDoctores(context:Context):ArrayList<Paciente>{
        val db: DBgestor = DBgestor(context,null)
        return db.getDoctores()
    }
}