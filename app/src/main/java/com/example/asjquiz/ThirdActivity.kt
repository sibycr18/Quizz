package com.example.asjquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        var button3 : Button = findViewById(R.id.button3)
        var intent3 : Intent = Intent (this ,MainActivity::class.java )
        button3.setOnClickListener {
            startActivity(intent3)
        }

    }
}