package com.example.plataformaescolar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import org.json.JSONObject
import com.example.plataformaescolar.databinding.ActivityResidenciaBinding
import kotlinx.android.synthetic.main.activity_residencia.*

class Residencia : AppCompatActivity() {

    private lateinit var binding:ActivityResidenciaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResidenciaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var usuario = intent.getStringExtra("usuario")
        val jsonUsuario = JSONObject(usuario)
        val jsonUsuarioEdit = jsonUsuario

        binding.numeroControlR.setText(jsonUsuario.getString("noControl"))
        binding.nombreR.setText(jsonUsuario.getString("nombre"))
        binding.carreraR.setText(jsonUsuario.getString("carrera"))
        binding.semestreR.setText(jsonUsuario.getString("semestre"))



        binding.btnRegistro.setOnClickListener {
            val Proyecto: String = ProyectoR.text.toString()
            val Lugar: String = LugarR.text.toString()
            val Semestre: String = semestreR.text.toString()
            val NSem : Int = Semestre.toInt()

            if (Proyecto == "" || Lugar == "") {
                Toast.makeText(this, "Hay campos vacios", Toast.LENGTH_SHORT).show()
            } else {
                if (NSem >= 9){
                    Toast.makeText(this, "Se registro exitosamente", Toast.LENGTH_SHORT).show()
                }
                Toast.makeText(this, "Usted no es de 9vo", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRegresar.setOnClickListener {
            val intent = Intent(this, Reinscripcion::class.java)
            startActivity(intent)
            finish()
        }



    }
}