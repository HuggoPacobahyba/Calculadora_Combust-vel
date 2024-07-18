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

const val KEY_DISTANCE = "DistanceActivity.key"

class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distance)

        val price = intent.getFloatExtra(KEY_PRICE, 0f)
        val consume = intent.getFloatExtra(KEY_CONSUME, 0f)

        val edtDistance = findViewById<TextInputEditText>(R.id.edt_distance)
        val btn_proximo3 = findViewById<Button>(R.id.btn_proximo3)

        btn_proximo3.setOnClickListener() {

            val distanceStr: String = edtDistance.text.toString()

            if (distanceStr == "") {

                Snackbar.make(
                    edtDistance,
                    "Preencha o campo",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {
                val distance = distanceStr.toFloatOrNull()

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_DISTANCE, distance)
                intent.putExtra(KEY_CONSUME, consume)
                intent.putExtra(KEY_PRICE, price)
                startActivity(intent)
            }

        }

    }
}