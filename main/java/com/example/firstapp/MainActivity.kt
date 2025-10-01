package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setTitle("ToastHandler")
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.button_ok)
        btn.setOnClickListener {
            val toast = Toast.makeText(this,"Кнопка ОК", Toast.LENGTH_SHORT)
            toast.show()
        }

        val editText = findViewById<EditText>(R.id.edit_text)
        val buttonLog = findViewById<Button>(R.id.button_log)
        val buttonTimber = findViewById<Button>(R.id.button_timber)

        buttonLog.setOnClickListener {
            val text = editText.text.toString()
            Log.v("From EditText", text)
        }

        Timber.plant(Timber.DebugTree())

        buttonTimber.setOnClickListener {
            val text = editText.text.toString()
            Timber.v(text)
        }

        val buttonNext = findViewById<Button>(R.id.next_activity_btn)
        buttonNext.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}
