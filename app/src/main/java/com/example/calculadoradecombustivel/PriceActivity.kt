package com.example.calculadoradecombustivel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_PRICE = "PriceActivity.key"

class PriceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_price)

        val edtPrice = findViewById<TextInputEditText>(R.id.edt_fuelPrice)
        val btn_proximo1 = findViewById<Button>(R.id.btn_proximo1)

        btn_proximo1.setOnClickListener() {

            val priceStr: String = edtPrice.text.toString()

            if (priceStr == "") {
                Snackbar.make(
                    edtPrice,
                    "Preencha o campo",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {
                val price = priceStr.toFloatOrNull()

                val intent = Intent(this, ConsumeActivity::class.java)
                intent.putExtra(KEY_PRICE, price)
                startActivity(intent)
            }
        }

    }
}