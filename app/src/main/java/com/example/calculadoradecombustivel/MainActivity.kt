package com.example.calculadoradecombustivel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_Iniciar = findViewById<Button>(R.id.btn_Iniciar)

        btn_Iniciar.setOnClickListener() {

            val intent = Intent(this, PriceActivity::class.java)
            startActivity(intent)

        }


    }
}