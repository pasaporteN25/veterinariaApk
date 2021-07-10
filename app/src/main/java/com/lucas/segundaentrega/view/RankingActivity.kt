package com.lucas.segundaentrega.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucas.segundaentrega.R
import com.lucas.segundaentrega.viewmodel.PacienteViewModel
import com.lucas.segundaentrega.viewmodel.RankingViewModel
import com.lucas.segundaentrega.viewmodel.recycleview.PacienteAdapter

class RankingActivity : AppCompatActivity() {

    lateinit var rv_medicos:RecyclerView
    lateinit var DoctoresVM: RankingViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        DoctoresVM = ViewModelProvider(this).get(RankingViewModel::class.java)
        rv_medicos.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_medicos.adapter = PacienteAdapter(DoctoresVM.getDoctores(this))

    }
}