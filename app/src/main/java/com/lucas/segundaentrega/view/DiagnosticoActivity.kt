package com.lucas.segundaentrega.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucas.segundaentrega.R
import com.lucas.segundaentrega.viewmodel.PacienteViewModel
import com.lucas.segundaentrega.viewmodel.recycleview.PacienteAdapter
import java.lang.Exception
import android.util.Log
import android.widget.Toast
import com.lucas.segundaentrega.viewmodel.DiagnosticoViewModel

class DiagnosticoActivity : AppCompatActivity() {

    lateinit var nombre:EditText
    lateinit var buscar_n:Button
    lateinit var rv_pacientes:RecyclerView
    lateinit var resultado:EditText
    lateinit var causa:EditText
    lateinit var medicamentos:EditText
    lateinit var guardar:Button
    lateinit var PacienteVM: PacienteViewModel
    lateinit var DiagnosticoVM: DiagnosticoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnostico)

        inicializar()

        PacienteVM = ViewModelProvider(this).get(PacienteViewModel::class.java)

        buscar_n.setOnClickListener(
            View.OnClickListener {
                try{
                    rv_pacientes.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                    rv_pacientes.adapter = PacienteAdapter(PacienteVM.getPacientes(this,nombre.text.toString()))
                }catch (e:Exception){
                    Log.e("Error al buscar",e.message.toString())
                }


            }
        )

        DiagnosticoVM = ViewModelProvider(this).get(DiagnosticoViewModel::class.java)

        guardar.setOnClickListener(
            View.OnClickListener {
                if(DiagnosticoVM.saveDiagnostico(nombre.text.toString(),resultado.text.toString(), causa.text.toString(),medicamentos.text.toString(), this))
                    Toast.makeText(it.context,"Datos guardados", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(it.context,"Error al guardar diagnostico", Toast.LENGTH_SHORT).show()
            }
        )

    }

    private fun inicializar(){
        nombre = findViewById(R.id.name_diag)
        buscar_n = findViewById(R.id.nombre_buscar)
        rv_pacientes = findViewById(R.id.rv_pacientes)
        resultado = findViewById(R.id.res_diag)
        causa = findViewById(R.id.causa_diag)
        medicamentos = findViewById(R.id.med_diag)
        guardar = findViewById(R.id.guardar_diag)
    }


}