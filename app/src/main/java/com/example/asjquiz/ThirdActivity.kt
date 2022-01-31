package com.example.asjquiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        supportActionBar?.setBackgroundDrawable((getDrawable(R.color.purple_500)))

        var congo : TextView = findViewById(R.id.textView)

        var finalScore : TextView = findViewById(R.id.textView7)
        finalScore.text = intent.getStringExtra("score").toString()
        if ((finalScore.text) == "0") {
            congo.text = "Oops!"
        } else {
            congo.text = "Congratulations!"
        }

        var button3 : Button = findViewById(R.id.button3)

        var intent3 = Intent (this ,MainActivity::class.java )
        button3.setOnClickListener {
            startActivity(intent3)
        }
    }
}