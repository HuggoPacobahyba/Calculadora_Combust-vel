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

const val KEY_CONSUME = "ConsumeActivity.key"

class ConsumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consume)

        val price = intent.getFloatExtra(KEY_PRICE, 0f)

        val edtConsume = findViewById<TextInputEditText>(R.id.edt_fuelConsume)
        val btn_proximo2 = findViewById<Button>(R.id.btn_proximo2)

        btn_proximo2.setOnClickListener() {

            val consumeStr: String = edtConsume.text.toString()

            if (consumeStr == "") {

                Snackbar.make(
                    edtConsume,
                    "Preencha o Campo",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {
                val consume = consumeStr.toFloatOrNull()

                val intent = Intent(this, DistanceActivity::class.java)
                intent.putExtra(KEY_CONSUME, consume)
                intent.putExtra(KEY_PRICE, price)
                startActivity(intent)
            }

        }


    }


}