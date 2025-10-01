package com.example.firstapp

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_main)

        setTitle("Attributes")

        val editText = findViewById<EditText>(R.id.editText)

        findViewById<Button>(R.id.button_black_text).setOnClickListener {
            editText.setTextColor(Color.BLACK)
        }
        findViewById<Button>(R.id.button_red_text).setOnClickListener {
            editText.setTextColor(Color.RED)
        }
        findViewById<Button>(R.id.button_small).setOnClickListener {
            editText.textSize = 8f
        }
        findViewById<Button>(R.id.button_large).setOnClickListener {
            editText.textSize = 24f
        }
        findViewById<Button>(R.id.button_white_bg).setOnClickListener {
            editText.setBackgroundColor(Color.WHITE)
        }
        findViewById<Button>(R.id.button_yellow_bg).setOnClickListener {
            editText.setBackgroundColor(Color.YELLOW)
        }
    }
}