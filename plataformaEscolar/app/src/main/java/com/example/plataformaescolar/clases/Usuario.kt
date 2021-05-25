package com.example.plataformaescolar.clases

data class Usuario(
    var nombre: String? = null,
    var noControl: String? = null,
    var carrera: String? = null,
    var semestre: String? = null,
    var contrasena: String? = null
){
    //instancia

    companion object{
        var json : String =
            "{'nombre': 'Oscar Tera'," +
                    "'noControl': '18120234'," +
                    "'carrera': 'TICS'," +
                    "'semestre': '6'," +
                    "'contrasena': '123'}"
    }
}
