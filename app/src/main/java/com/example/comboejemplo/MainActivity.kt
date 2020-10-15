package com.example.comboejemplo

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {



    var opciones = arrayOf("Negritas","Cursivas","Negrita/Cursiva") // arreglo de opciones en kotlin
    //Estructura de un Spinner.
    lateinit var spinnerOpciones: Spinner
    lateinit var txtSaludoCodigo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declaracion del spinner
        spinnerOpciones = this.spinner
        txtSaludoCodigo = this.txtSaludo // si quiero utilizar la misma variable uso un findViewById

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)// lleva tres valores, el this, el personalizado y las opciones

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOpciones.adapter = adaptador
        // para reutilizar el evento.
        spinnerOpciones.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
       // Log.v("SpinnerApp","Se seleccionó")
        if (position==0)
            txtSaludoCodigo.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
            else if (position==1)
            txtSaludoCodigo.typeface = Typeface.defaultFromStyle(Typeface.ITALIC)
        else if (position==2)
            txtSaludoCodigo.typeface = Typeface.defaultFromStyle(Typeface.BOLD_ITALIC)


    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}
