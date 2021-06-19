package com.example.plataformaescolar.modules

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.jvm.Throws

class DBManager
    (context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int)
    : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        var sql = ""

        db?.let {
            sql = """ 
                CREATE TABLE alumnos (
                id INTEGER PRIMARY KEY NOT NULL,
                NControl INT,
                Nombre TEXT NOT NULL,
                Carrera TEXT NOT NULL,
                Semestre INT,
                Contrasenia TEXT NOT NUL
                )
            """
            it.execSQL(sql)

            sql =
                    "INSERT INTO alumnos" +
                            "(NControl,Nombre,Carrera,Semestre,Contrasenia)" +
                            " VALUES ('18120234','Oscar Tera','ITICS','9','123')"
            it.execSQL(sql)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
        @Throws
            fun readAll(): ArrayList<alumnos>{
                 val db = readableDatabase

                val sql = "SELECT * FROM alumnos"
                val alumnos = ArrayList<alumnos>()

                val cursor = db.rawQuery(sql,null)
                while (cursor.moveToNext()){
                    val alumno = alumnos(
                            cursor.getInt(0),
                            cursor.getInt(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getInt(4),
                            cursor.getString(5)
                    )
                    alumnos.add(alumno)
                }
            db.close()
            
            return alumnos

        }
}