package com.example.asjquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button1 : Button = findViewById(R.id.button1)
        var intent = Intent (this ,SecondActivity::class.java )
        button1.setOnClickListener {
            startActivity(intent)
            finish()
        }
    }
}