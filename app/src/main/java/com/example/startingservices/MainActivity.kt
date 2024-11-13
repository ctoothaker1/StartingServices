package com.example.startingservices

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText : EditText
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        button = findViewById(R.id.btnStartCountdown)

        button.setOnClickListener{

            val timeForService = editText.text.toString().toIntOrNull()
            Log.d("MainActivity", "Button clicked with time: $timeForService")
            val intent = Intent(this, TimerService::class.java)

            intent.putExtra("timeForService",timeForService)
            startService(intent)
        }

    }
}