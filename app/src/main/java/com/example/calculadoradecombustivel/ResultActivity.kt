package com.example.calculadoradecombustivel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultPrice = findViewById<TextView>(R.id.tv_priceResult)
        val resultConsume = findViewById<TextView>(R.id.tv_consumeResult)
        val resultKm = findViewById<TextView>(R.id.tv_KmResult)
        val result = findViewById<TextView>(R.id.tv_Result)
        val btn_inicio = findViewById<Button>(R.id.btn_novocalculo)

        val price = intent.getFloatExtra(KEY_PRICE, 0f)
        val consume = intent.getFloatExtra(KEY_CONSUME, 0f)
        val km = intent.getFloatExtra(KEY_DISTANCE, 0f)

        resultPrice.text = price.toString()
        resultConsume.text = consume.toString()
        resultKm.text = km.toString()

        val calcTotal = if (consume != 0f) {
            (km / consume) * price

        } else {
            0f
        }
        result.text = "R$ %.2f".format(calcTotal)

        btn_inicio.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}