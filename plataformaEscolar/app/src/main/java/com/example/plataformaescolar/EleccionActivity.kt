package com.example.plataformaescolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.plataformaescolar.clases.AdapterCalificacion
import com.example.plataformaescolar.clases.AdapterReticula
import com.example.plataformaescolar.clases.Calificacion
import com.example.plataformaescolar.databinding.ActivityCalificacionesBinding
import com.example.plataformaescolar.databinding.ActivityEleccionBinding
import org.json.JSONObject

class EleccionActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityEleccionBinding

    private var numSemestre = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEleccionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val miJson = resources.getString(R.string.AlumnosVerano)
        val jsonAlumnoVerano = JSONObject(miJson)
        val arrayAlumnoVerano = jsonAlumnoVerano.getJSONArray("usuarios")

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

                    Toast.makeText(this, "Ha sido registrado exitosamente", Toast.LENGTH_SHORT).show()
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
                for (i in 0..(arrayMaterias.length() - 1)) {
                    val jsonMateria = arrayMaterias.getJSONObject(i)
                    lista.add(Calificacion(jsonMateria.getString("nombre")))
                }
            }
            1 -> {
                var arrayMaterias = jsonMaterias1.getJSONArray("semestre2")
                for (i in 0..(arrayMaterias.length() - 1)) {
                    val jsonMateria = arrayMaterias.getJSONObject(i)
                    lista.add(Calificacion(jsonMateria.getString("nombre")))
                }
            }
            2 -> {
                var arrayMaterias = jsonMaterias1.getJSONArray("semestre3")
                for (i in 0..(arrayMaterias.length() - 1)) {
                    val jsonMateria = arrayMaterias.getJSONObject(i)
                    lista.add(Calificacion(jsonMateria.getString("nombre")))
                }
            }
            3 -> {
                var arrayMaterias = jsonMaterias1.getJSONArray("semestre4")
                for (i in 0..(arrayMaterias.length() - 1)) {
                    val jsonMateria = arrayMaterias.getJSONObject(i)
                    lista.add(Calificacion(jsonMateria.getString("nombre")))
                }
            }
            4 -> {
                var arrayMaterias = jsonMaterias1.getJSONArray("semestre5")
                for (i in 0..(arrayMaterias.length() - 1)) {
                    val jsonMateria = arrayMaterias.getJSONObject(i)
                    lista.add(Calificacion(jsonMateria.getString("nombre")))
                }
            }
            5 -> {
                var arrayMaterias = jsonMaterias1.getJSONArray("semestre6")
                for (i in 0..(arrayMaterias.length() - 1)) {
                    val jsonMateria = arrayMaterias.getJSONObject(i)
                    lista.add(Calificacion(jsonMateria.getString("nombre")))
                }
            }
            6 -> {
                var arrayMaterias = jsonMaterias1.getJSONArray("semestre7")
                for (i in 0..(arrayMaterias.length() - 1)) {
                    val jsonMateria = arrayMaterias.getJSONObject(i)
                    lista.add(Calificacion(jsonMateria.getString("nombre")))
                }
            }
        }
        binding.listViewMaterias.adapter = AdapterReticula(this, R.layout.lista_reticula, lista)

    }//fin del spinner de numero de semestre

    override fun onNothingSelected(p0: AdapterView<*>?) {}
}