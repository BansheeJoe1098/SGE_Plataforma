package com.example.plataformaescolar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plataformaescolar.databinding.ActivityDatosInscripcionBinding
import org.json.JSONObject

class DatosInscripcion : AppCompatActivity() {
    private lateinit var binding: ActivityDatosInscripcionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatosInscripcionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val miJson = intent.getStringExtra("verano")
        val jsonAlumnoVerano = JSONObject(miJson)
        val arrayAlumnoVerano = jsonAlumnoVerano.getJSONArray("usuarios")
        val arrayMateriaVerano = jsonAlumnoVerano.getJSONArray("Materias")
        val m = arrayMateriaVerano.getJSONObject(0)
        var usuario = intent.getStringExtra("usuario")
        val jsonUsuario = JSONObject(usuario)


        binding.numeroControl.setText(jsonUsuario.getString("noControl"))
        binding.nombre.setText(jsonUsuario.getString("nombre"))
        binding.carrera.setText(jsonUsuario.getString("carrera"))
        val ff = jsonUsuario.getString("noControl")
        for (i in 0..(arrayAlumnoVerano.length()-1)){
            var control =  arrayAlumnoVerano.getJSONObject(i)
            if (ff==control.getString("noControl")){
                binding.materia.setText(control.getString("materia"))
                val materia = control.getString("materia")
                val nA = m.getString(materia)
                println("esto es lo que tiene  " + nA )
                //if(nA>= 10){
                  //  binding.referencia.setText(jsonUsuario.getString("NoReferencia"))
                //}else{
                    binding.referencia.setText("No hay suficientes alumnos para el grupo")
                //}
            }
        }

    }
}