package com.lucas.segundaentrega.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.lucas.segundaentrega.R

class MainActivity : AppCompatActivity() {

    lateinit var ingreso:Button
    lateinit var diagn:Button
    lateinit var rank:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializar()

        ingreso.setOnClickListener(
            View.OnClickListener {
                val intent = Intent(this,IngresoActivity::class.java)
                startActivity(intent)
            }
        )

        diagn.setOnClickListener(
            View.OnClickListener {
                val intent = Intent(this,DiagnosticoActivity::class.java)
                startActivity(intent)
            }
        )

        rank.setOnClickListener(
            View.OnClickListener {
                val intent = Intent(this,RankingActivity::class.java)
                startActivity(intent)
            }
        )

    }

    private fun inicializar(){
        ingreso = findViewById(R.id.in_b)
        diagn = findViewById(R.id.diag_b)
        rank = findViewById(R.id.rank_b)

    }
}