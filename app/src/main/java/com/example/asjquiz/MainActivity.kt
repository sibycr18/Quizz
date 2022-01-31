package com.example.asjquiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setBackgroundDrawable((getDrawable(R.color.purple_500)))

        var button1 : Button = findViewById(R.id.button1)
        var intent = Intent (this ,SecondActivity::class.java )
        button1.setOnClickListener {
            startActivity(intent)
            finish()
        }
    }
}