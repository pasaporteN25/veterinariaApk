package com.lucas.segundaentrega.viewmodel.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lucas.segundaentrega.R
import com.lucas.segundaentrega.model.Paciente
import org.w3c.dom.Text

class PacienteAdapter (val lista: ArrayList<Paciente>) : RecyclerView.Adapter<PacienteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.vpacientes_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.nombre.text = lista[position].nombre
        holder.tipo.text = lista[position].tipo
        holder.raza.text = lista[position].raza
        holder.medico.text = lista[position].medico

        holder.elegir.setOnClickListener(
            View.OnClickListener {
                //aca tendria que devolver el nombre al activity diagnostico
                //callbackInterface.returnCallback(holder.nombre.text.toString())
            }
        )

    }

    override fun getItemCount(): Int {
        return lista.size
    }


    class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {

        //mapeo el layout a mostrar
        var nombre: TextView
        var tipo: TextView
        var raza: TextView
        var medico: TextView
        var elegir: Button

        init {
            nombre = view.findViewById(R.id.item_nombre)
            tipo = view.findViewById(R.id.item_tipo)
            raza = view.findViewById(R.id.item_raza)
            medico = view.findViewById(R.id.item_medico)
            elegir = view.findViewById(R.id.item_selec)
        }

    }

//    interface CallbackInterface{
//        fun returnCallback(name: String)
//    }


}