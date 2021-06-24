package com.example.plataformaescolar.modules

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBMaterias  (context: Context?,
                   name: String?,
                   factory: SQLiteDatabase.CursorFactory?,
                   version: Int)
    : SQLiteOpenHelper(context, name, factory, version){
    override fun onCreate(db: SQLiteDatabase?) {
        var sql = ""

        db?.let {
            sql = """ 
                CREATE TABLE materia (
                id INTEGER PRIMARY KEY NOT NULL,
                Materia TEXT NOT NULL,
                NAlumnos INT
                )
            """
            it.execSQL(sql)
            sql =
                    "INSERT INTO materia" +
                            "(Materia,NAlumnos)" +
                            " VALUES ('Sistemas Opertivos','10')"
            it.execSQL(sql)
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        fun readall ():ArrayList<materias>{
            val db = writableDatabase

            val sql = "SELECT * FROM materia"
            val Materia = ArrayList<materias>()

            val cursor = db.rawQuery(sql,null)
            while (cursor.moveToNext()){
                val materia = materias(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2)
                )
                Materia.add(materia)
            }
            db.close()

            return Materia
        }

    }

}