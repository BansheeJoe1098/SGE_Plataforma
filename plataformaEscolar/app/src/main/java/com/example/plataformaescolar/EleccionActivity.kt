package com.example.plataformaescolar

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.plataformaescolar.clases.AdapterReticula
import com.example.plataformaescolar.clases.Calificacion
import com.example.plataformaescolar.databinding.ActivityEleccionBinding
import org.json.JSONObject

class EleccionActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityEleccionBinding

    private var numSemestre = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEleccionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val miJson = intent.getStringExtra("verano")
        val jsonAlumnoVerano = JSONObject(miJson)
        val arrayAlumnoVerano = jsonAlumnoVerano.getJSONArray("usuarios")
        val arrayMateriaVerano = jsonAlumnoVerano.getJSONArray("Materias")
        val m = arrayMateriaVerano.getJSONObject(0)
        var usuario = intent.getStringExtra("usuario")
        val jsonUsuario = JSONObject(usuario)
        binding.spinnerSemestres.onItemSelectedListener = this

        binding.btnRegistar.setOnClickListener {
            val usuario = jsonUsuario.getString("noControl")
            for (i in 0..(arrayAlumnoVerano.length()-1)){
                var control =  arrayAlumnoVerano.getJSONObject(i)
                if (usuario==control.getString("noControl")){
                    Toast.makeText(this, "Ya se encuentra registrado", Toast.LENGTH_SHORT).show()


                }else{

                  val i  = binding.spinnerSemestres.selectedItem
                when(i){
                    "Semestre 1" -> {
                       val jsonAlumnoVeranoEdit = JSONObject()
                        jsonAlumnoVeranoEdit.put("nombre",jsonUsuario.getString("nombre"))
                        jsonAlumnoVeranoEdit.put("noControl",jsonUsuario.getString("noControl"))
                        jsonAlumnoVeranoEdit.put("noReferencia",jsonUsuario.getString("NoReferencia"))
                        jsonAlumnoVeranoEdit.put("materia","Fundamentos De Investigacion")
                        val alumno = jsonAlumnoVerano.getJSONArray("usuarios")
                        alumno.put(jsonAlumnoVeranoEdit)
                     var n = m.getInt("fundamentosInvestigacion") +1
                       m.put("fundamentosInvestigacion", n)
                        Toast.makeText(this, "Te has registrado a fundamentos de investigacion", Toast.LENGTH_SHORT).show()
                    }
                    "Semestre 2" -> {
                        val jsonAlumnoVeranoEdit = JSONObject()
                        jsonAlumnoVeranoEdit.put("nombre",jsonUsuario.getString("nombre"))
                        jsonAlumnoVeranoEdit.put("noControl",jsonUsuario.getString("noControl"))
                        jsonAlumnoVeranoEdit.put("noReferencia",jsonUsuario.getString("NoReferencia"))
                        jsonAlumnoVeranoEdit.put("materia","Contabilidad")
                        val alumno = jsonAlumnoVerano.getJSONArray("usuarios")
                        alumno.put(jsonAlumnoVeranoEdit)
                        var n = m.getInt("contabilidad") +1
                        m.put("contabilidad", n)
                        Toast.makeText(this, "Te has registrado a cotabilidad", Toast.LENGTH_SHORT).show()
                    }
                    "Semestre 3" -> {
                        val jsonAlumnoVeranoEdit = JSONObject()
                        jsonAlumnoVeranoEdit.put("nombre",jsonUsuario.getString("nombre"))
                        jsonAlumnoVeranoEdit.put("noControl",jsonUsuario.getString("noControl"))
                        jsonAlumnoVeranoEdit.put("noReferencia",jsonUsuario.getString("NoReferencia"))
                        jsonAlumnoVeranoEdit.put("materia","Desarrollo sustentable")
                        val alumno = jsonAlumnoVerano.getJSONArray("usuarios")
                        alumno.put(jsonAlumnoVeranoEdit)
                        var n = m.getInt("desarrollo") +1
                        m.put("desarrollo", n)
                        Toast.makeText(this, "Te has registrado a desarrollo sustentabe", Toast.LENGTH_SHORT).show()
                    }
                    "Semestre 4" -> {
                        val jsonAlumnoVeranoEdit = JSONObject()
                        jsonAlumnoVeranoEdit.put("nombre",jsonUsuario.getString("nombre"))
                        jsonAlumnoVeranoEdit.put("noControl",jsonUsuario.getString("noControl"))
                        jsonAlumnoVeranoEdit.put("noReferencia",jsonUsuario.getString("NoReferencia"))
                        jsonAlumnoVeranoEdit.put("materia","Circuitos")
                        val alumno = jsonAlumnoVerano.getJSONArray("usuarios")
                        alumno.put(jsonAlumnoVeranoEdit)
                        var n = m.getInt("circuitos") +1
                        m.put("circuitos", n)
                        Toast.makeText(this, "Te has registrado a circuitos", Toast.LENGTH_SHORT).show()
                    }
                    "Semestre 5" -> {
                        val jsonAlumnoVeranoEdit = JSONObject()
                        jsonAlumnoVeranoEdit.put("nombre",jsonUsuario.getString("nombre"))
                        jsonAlumnoVeranoEdit.put("noControl",jsonUsuario.getString("noControl"))
                        jsonAlumnoVeranoEdit.put("noReferencia",jsonUsuario.getString("NoReferencia"))
                        jsonAlumnoVeranoEdit.put("materia","Administracion")
                        val alumno = jsonAlumnoVerano.getJSONArray("usuarios")
                        alumno.put(jsonAlumnoVeranoEdit)
                        var n = m.getInt("administracion") +1
                        m.put("administracion", n)
                        Toast.makeText(this, "Te has registrado a administracion", Toast.LENGTH_SHORT).show()
                    }
                    "Semestre 6" -> {
                        val jsonAlumnoVeranoEdit = JSONObject()
                        jsonAlumnoVeranoEdit.put("nombre",jsonUsuario.getString("nombre"))
                        jsonAlumnoVeranoEdit.put("noControl",jsonUsuario.getString("noControl"))
                        jsonAlumnoVeranoEdit.put("noReferencia",jsonUsuario.getString("NoReferencia"))
                        jsonAlumnoVeranoEdit.put("materia","programacion web")
                        val alumno = jsonAlumnoVerano.getJSONArray("usuarios")
                        alumno.put(jsonAlumnoVeranoEdit)
                        var n = m.getInt("programacionWEB") +1
                        m.put("programacionWEB", n)
                        Toast.makeText(this, "Te has registrado a programacion web", Toast.LENGTH_SHORT).show()
                    }
                    "Semestre 7" -> {
                        val jsonAlumnoVeranoEdit = JSONObject()
                        jsonAlumnoVeranoEdit.put("nombre",jsonUsuario.getString("nombre"))
                        jsonAlumnoVeranoEdit.put("noControl",jsonUsuario.getString("noControl"))
                        jsonAlumnoVeranoEdit.put("noReferencia",jsonUsuario.getString("NoReferencia"))
                        jsonAlumnoVeranoEdit.put("materia","sistemas operativos")
                        val alumno = jsonAlumnoVerano.getJSONArray("usuarios")
                        alumno.put(jsonAlumnoVeranoEdit)
                        var n = m.getInt("sistemasOperativos") +1
                        m.put("sistemasOperativos", n)
                        Toast.makeText(this, "Te has registrado a sisemas operativos", Toast.LENGTH_SHORT).show()
                    }
                }


                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("usuario", jsonUsuario.toString())
                    intent.putExtra("verano",jsonAlumnoVerano.toString())
                    startActivity(intent)
                    finish()
                }

            }

        }
    }


    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val json1 = resources.getString(R.string.jsonMaterias)
        val jsonMaterias1 = JSONObject(json1)
        //var arrayMaterias : JSONObject

        val lista : MutableList<Calificacion> = mutableListOf()
        numSemestre = resources.getStringArray(R.array.numSemestres)[p2]

        when(p2){
            0 -> {
                var arrayMaterias = jsonMaterias1.getJSONArray("semestre1")
                    val jsonMateria = arrayMaterias.getJSONObject(0)
                    lista.add(Calificacion(jsonMateria.getString("nombre")))

            }
            1 -> {
                var arrayMaterias = jsonMaterias1.getJSONArray("semestre2")
                    val jsonMateria = arrayMaterias.getJSONObject(0)
                    lista.add(Calificacion(jsonMateria.getString("nombre")))

            }
            2 -> {
                var arrayMaterias = jsonMaterias1.getJSONArray("semestre3")
                    val jsonMateria = arrayMaterias.getJSONObject(0)
                    lista.add(Calificacion(jsonMateria.getString("nombre")))

            }
            3 -> {
                var arrayMaterias = jsonMaterias1.getJSONArray("semestre4")
                    val jsonMateria = arrayMaterias.getJSONObject(0)
                    lista.add(Calificacion(jsonMateria.getString("nombre")))

            }
            4 -> {
                var arrayMaterias = jsonMaterias1.getJSONArray("semestre5")
                    val jsonMateria = arrayMaterias.getJSONObject(0)
                    lista.add(Calificacion(jsonMateria.getString("nombre")))
            }
            5 -> {
                var arrayMaterias = jsonMaterias1.getJSONArray("semestre6")
                    val jsonMateria = arrayMaterias.getJSONObject(0)
                    lista.add(Calificacion(jsonMateria.getString("nombre")))

            }
            6 -> {
                var arrayMaterias = jsonMaterias1.getJSONArray("semestre7")
                    val jsonMateria = arrayMaterias.getJSONObject(0)
                    lista.add(Calificacion(jsonMateria.getString("nombre")))

            }
        }
        binding.listViewMaterias.adapter = AdapterReticula(this, R.layout.lista_reticula, lista)

    }//fin del spinner de numero de semestre

    override fun onNothingSelected(p0: AdapterView<*>?) {}
}