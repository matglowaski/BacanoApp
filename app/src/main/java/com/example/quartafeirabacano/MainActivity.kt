package com.example.quartafeirabacano

import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val listaBacano = listOf(
        Bacano("Pirata Bacano", R.drawable.bacanopirata),
        Bacano("Bacano", R.drawable.bacanosim),
        Bacano("Rayman Bacano", R.drawable.bacanojogo),
        Bacano("Imperador Bacano", R.drawable.bacanojulio),
        Bacano("Bacano do Posto", R.drawable.bacanoposto)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
    val diaSemana = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    if(diaSemana == Calendar.WEDNESDAY) {
        setContentView(R.layout.activity_main)
    }else{
        setContentView(R.layout.activity_not_wednesday)
    }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    data class Bacano(val nome: String, val fotoId: Int)

    var sorteouHoje = false
    fun sortear(view: View){
        if(sorteouHoje == false){
            val textBacano = findViewById<TextView>(R.id.textBacano)
            val imgBacano = findViewById<ImageView>(R.id.imgBacano)
            val bacanoSortear = listaBacano.random()
            textBacano.setText(bacanoSortear.nome)
            imgBacano.setImageResource(bacanoSortear.fotoId)
            sorteouHoje = true
        }else{
            Toast.makeText(this, "Você já pegou seu sapo de hoje!", Toast.LENGTH_SHORT).show()
        }
    }
}
