package com.example.plataformaescolar.modules

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.text.Editable
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
                Contrasenia TEXT NOT NUL,
                Materia TEXT NOT NULL
                )
            """
            it.execSQL(sql)

            sql =
                    "INSERT INTO alumnos" +
                            "(NControl,Nombre,Carrera,Semestre,Contrasenia,Materia)" +
                            " VALUES ('18120234','Oscar Tera','ITICS','9','123','Sistemas Operativos')"
            it.execSQL(sql)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

    @Throws
    fun find(ncontrol: Editable? = null): ArrayList<alumnos> {
        val db = readableDatabase

        var sql = "SELECT * FROM alumnos"

        val alumnos = ArrayList<alumnos>()

        ncontrol?.let {
            if (it.isNotEmpty()) {
                sql += " WHERE NControl LIKE '%$it%'"
            }
        }
            val cursor = db.rawQuery(sql, null)
            while (cursor.moveToNext()) {
                val alumno = alumnos(
                        cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getString(5),
                        cursor.getString(6)
                )
                alumnos.add(alumno)
            }
            db.close()

            return alumnos

        }
        fun newalumnno(alumnos: alumnos) {

            val db = writableDatabase
            var sql = ""

            sql = "INSERT INTO alumnos" +
                    "(NControl,Nombre,Carrera,Semestre,Contrasenia,Materia)" +
                    " VALUES (?,?,?,?,?,?)"

            val compileStm = db.compileStatement(sql)
            compileStm.bindString(1, alumnos.NControl.toString())
            compileStm.bindString(2, alumnos.Nombre)
            compileStm.bindString(3, alumnos.Carrera)
            compileStm.bindString(4, alumnos.Contrasenia)
            compileStm.bindString(5, alumnos.Materia)

            compileStm.execute()

            db.close()


        }

        fun update(alumnos: alumnos) {
            val db = writableDatabase
            val values = ContentValues()

            values.put("NControl", alumnos.NControl)
            values.put("Nombre", alumnos.Nombre)
            values.put("Carrera", alumnos.Carrera)
            values.put("Semestre", alumnos.Semestre)
            values.put("Cantrasenia", alumnos.Contrasenia)
            values.put("Materia", alumnos.Materia)

            db.update("alumnos", values, "id = ?", arrayOf(alumnos.id.toString()))
            db.close()
        }

        fun delete(id: String? = null) {
            val db = writableDatabase
            db.delete("alumnos", "id = ?", arrayOf(id))
            db.close()
        }
    }