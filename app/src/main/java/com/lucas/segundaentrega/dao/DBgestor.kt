package com.lucas.segundaentrega.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.lucas.segundaentrega.model.Diagnostico
import com.lucas.segundaentrega.model.Paciente

class DBgestor (context: Context, factory: SQLiteDatabase.CursorFactory?): SQLiteOpenHelper(context, DB_NAME, factory, DB_VERSION) {

    companion object{
        private val DB_NAME = "pacientes1.db"
        private val DB_VERSION = 1
        val TABLA = "pacientes"
        val COLUMN_ID = "id"
        val COLUMN_NOMBRE = "nombre"
        val COLUMN_TIPO = "tipo"
        val COLUMN_RAZA = "raza"
        val COLUMN_EDAD = "edad"
        val COLUMN_CAUSA = "causa"
        val COLUMN_MEDICO = "medico"

        val TABLA_DIAG = "diagnostico"
        val COLUMN_RESUL = "resultado"
        val COLUMN_CAUSA_DIAG = "causa"
        val COLUMN_MEDICAM = "medicamentos"
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS "+ TABLA)
        onCreate(db)
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val createTablePac = (
                "CREATE TABLE " + TABLA + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NOMBRE + " TEXT, " +
                        COLUMN_TIPO + " TEXT, " +
                        COLUMN_RAZA + " TEXT, " +
                        COLUMN_EDAD + " TEXT, " +
                        COLUMN_CAUSA + " TEXT, " +
                        COLUMN_MEDICO + " TEXT ) " )

        db?.execSQL(createTablePac)

        val createTableDiag = (
                "CREATE TABLE " + TABLA_DIAG + " ( " + COLUMN_NOMBRE + " TEXT, " +
                COLUMN_RESUL + " TEXT, " +
                COLUMN_CAUSA_DIAG + " TEXT " +
                COLUMN_MEDICAM + " TEXT, " +
                "FOREIGN KEY ($COLUMN_NOMBRE) REFERENCES $TABLA($COLUMN_NOMBRE) ) "
                )
        db?.execSQL(createTableDiag)

    }

    fun saveDiagnostico(diagnostico: Diagnostico): Boolean{
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(COLUMN_NOMBRE, diagnostico.nombre)
        values.put(COLUMN_RESUL,diagnostico.resultado)
        values.put(COLUMN_CAUSA_DIAG,diagnostico.causa)
        values.put(COLUMN_MEDICAM,diagnostico.medicamento)

        db.insert(TABLA_DIAG, null,values)
        return true
    }

    fun saveConsulta(paciente: Paciente): Boolean {

        val db = this.writableDatabase
        val values = ContentValues()

        values.put(COLUMN_ID,paciente.id)
        values.put(COLUMN_NOMBRE,paciente.nombre)
        values.put(COLUMN_TIPO,paciente.tipo)
        values.put(COLUMN_RAZA,paciente.raza)
        values.put(COLUMN_EDAD,paciente.edad)
        values.put(COLUMN_CAUSA,paciente.causa)
        values.put(COLUMN_MEDICO,paciente.medico)

        db.insert(TABLA, null, values)

        return true
    }

    fun getPacientes(search:String): ArrayList<Paciente> {

        val db = this.readableDatabase
        val rpacientes : ArrayList<Paciente> = ArrayList<Paciente>()
        val query = "SELECT * FROM " + TABLA + " WHERE nombre = '$search'"
        //val query = "SELECT * FROM "+ TABLA

        val cursor = db.rawQuery(query,null)

        if (cursor.moveToFirst()) {
            do{
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
                val tipo = cursor.getString(cursor.getColumnIndex(COLUMN_TIPO))
                val raza = cursor.getString(cursor.getColumnIndex(COLUMN_RAZA))
                val edad = cursor.getString(cursor.getColumnIndex(COLUMN_EDAD))
                val causa = cursor.getString(cursor.getColumnIndex(COLUMN_CAUSA))
                val medico = cursor.getString(cursor.getColumnIndex(COLUMN_MEDICO))

                rpacientes.add(Paciente(id,nombre,tipo, raza, edad, causa,medico))
            } while(cursor.moveToNext())
        }else{
            println("La tabla no existe")
        }
        
        return rpacientes
    }

    fun getDoctores(): ArrayList<Paciente> {

        val db = this.readableDatabase
        val rpacientes : ArrayList<Paciente> = ArrayList<Paciente>()
        val query = "SELECT * FROM "+ TABLA

        val cursor = db.rawQuery(query,null)

        if (cursor.moveToFirst()) {
            do{
                val id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
                val tipo = cursor.getString(cursor.getColumnIndex(COLUMN_TIPO))
                val raza = cursor.getString(cursor.getColumnIndex(COLUMN_RAZA))
                val edad = cursor.getString(cursor.getColumnIndex(COLUMN_EDAD))
                val causa = cursor.getString(cursor.getColumnIndex(COLUMN_CAUSA))
                val medico = cursor.getString(cursor.getColumnIndex(COLUMN_MEDICO))

                rpacientes.add(Paciente(id,nombre,tipo, raza, edad, causa,medico))
            } while(cursor.moveToNext())
        }else{
            println("La tabla no existe")
        }

        //esta parte se puede generalizar
        return rpacientes
    }

}