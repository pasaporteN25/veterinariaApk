package com.lucas.segundaentrega.viewmodel.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lucas.segundaentrega.model.Paciente
import com.lucas.segundaentrega.R

class MedicoAdapter(val lista: ArrayList<Paciente>) : RecyclerView.Adapter<MedicoAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_ranking, parent, false)
        return MedicoAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.medico.text = lista[position].medico
        //holder.total.text = lista[position].total
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class ViewHolder (view:View) : RecyclerView.ViewHolder(view){
        var medico: TextView
        var total:TextView

        init {
            medico = view.findViewById(R.id.medico_rank)
            total = view.findViewById(R.id.total_rank)
        }
    }

}