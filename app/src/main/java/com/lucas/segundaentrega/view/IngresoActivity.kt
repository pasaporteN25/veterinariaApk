package com.lucas.segundaentrega.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucas.segundaentrega.R
import com.lucas.segundaentrega.viewmodel.PacienteViewModel

class IngresoActivity : AppCompatActivity() {

    lateinit var nombre:EditText
    lateinit var rgtipo:RadioGroup
    lateinit var raza:EditText
    lateinit var edad:EditText
    lateinit var causa:EditText
    lateinit var medico:EditText
    lateinit var guardarb:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso)

        inicializar()

        val pacienteVM = ViewModelProvider(this).get(PacienteViewModel::class.java)

        guardarb.setOnClickListener(
            View.OnClickListener {

                val selec: Int = rgtipo!!.checkedRadioButtonId
                val tipo_e: RadioButton = findViewById(selec)
                val tipo:String = tipo_e!!.text.toString()

                if(pacienteVM.guardarPaciente(nombre.text.toString(), tipo, raza.text.toString(), edad.text.toString(),causa.text.toString(), medico.text.toString(), it.context))
                    Toast.makeText(it.context,"Paciente ingresado", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(it.context, "Error al ingresar",Toast.LENGTH_SHORT).show()


            }
        )



    }

    private fun inicializar(){

        nombre = findViewById(R.id.name_in)
        rgtipo =findViewById(R.id.tipo_in)
        raza = findViewById(R.id.raza_in)
        edad = findViewById(R.id.edad_in)
        causa = findViewById(R.id.causa_in)
        medico = findViewById(R.id.medico_in)
        guardarb = findViewById(R.id.guardar_b)
    }


}