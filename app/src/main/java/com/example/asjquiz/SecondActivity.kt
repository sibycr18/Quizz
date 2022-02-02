package com.example.asjquiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var pointsText   : TextView
    private lateinit var quesNoText   : TextView
    private lateinit var questionText : TextView
    private lateinit var optionText1  : RadioButton
    private lateinit var optionText2  : RadioButton
    private lateinit var optionText3  : RadioButton
    private lateinit var optionText4  : RadioButton
    private lateinit var submitButton : Button
    private lateinit var intent2      : Intent
    private lateinit var errorText    : TextView
    private lateinit var questionBank : ArrayList<Question>

    private var score      : Int = 0
    private var questionNo : Int = 0
    var answer : String = ""

    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar?.setBackgroundDrawable((getDrawable(R.color.purple_500)))
        supportActionBar?.setDisplayShowTitleEnabled(false)

        pointsText   = findViewById(R.id.textView3)
        quesNoText   = findViewById(R.id.textView4)
        questionText = findViewById(R.id.textView5)
        optionText1  = findViewById(R.id.radioButton1)
        optionText2  = findViewById(R.id.radioButton2)
        optionText3  = findViewById(R.id.radioButton3)
        optionText4  = findViewById(R.id.radioButton4)

        errorText         = findViewById(R.id.textView9)
        errorText.text    = ""
        submitButton      = findViewById(R.id.button2)
        submitButton.text = "NEXT"

        questionBank = ArrayList()
        questionNo   = 0

        intent2 = Intent (this , ThirdActivity::class.java )

        setupquestion()
        initListeners()
        display(questionNo)
    }


    fun clearAll(){
        optionText1.isChecked = false
        optionText2.isChecked = false
        optionText3.isChecked = false
        optionText4.isChecked = false
    }


    fun isCorrect(value : String) : Boolean {
        return answer == value
    }


    @SuppressLint("SetTextI18n")
    fun display(index : Int) {
        quesNoText.text   = "Question no: " + (index + 1).toString() + " of 5"
        questionText.text = "Q)  " + questionBank.get(index).question
        optionText1.text  = questionBank.get(index).optionA
        optionText2.text  = questionBank.get(index).optionB
        optionText3.text  = questionBank.get(index).optionC
        optionText4.text  = questionBank.get(index).optionD
    }


    fun setupquestion() {
        questionBank.add(
            Question(
                "How do we interpret a dummy variable coefficient?  " ,
                "The difference between two means" ,
                "The difference between two coefficients" ,
                "The difference between two R-square values" ,
                "None of the above" ,
                "The difference between two means"
            )
        )

        questionBank.add(
            Question(
                "'OS' computer abbreviation usually means?" ,
                "Order of Significance" ,
                "Open Software" ,
                "Operating System" ,
                "Optical Sensor" ,
                "Operating System"
            )
        )

        questionBank.add(
            Question(
                "'.MOV' extension refers usually to what kind of file?" ,
                "Image file" ,
                "Animation/movie file" ,
                "Audio file" ,
                "MS Office document" ,
                "Animation/movie file"
            )
        )

        questionBank.add(
            Question(
                "What does SSL stand for?" ,
                "Secure Socket Layer" ,
                "System Socket Layer" ,
                "Superuser System Login" ,
                "Secure System Login" ,
                "Secure Socket Layer"
            )
        )

        questionBank.add(
            Question(
                "Which of the following numbers is farthest from the number 0 on the number line?" ,
                "5" ,
                "-5" ,
                "0" ,
                "10" ,
                "10"
            )
        )
    }

    @SuppressLint("SetTextI18n")
    fun initListeners() {
        optionText1.setOnClickListener {
            clearAll()
            optionText1.isChecked = true
            answer = optionText1.text.toString()
        }

        optionText2.setOnClickListener {
            clearAll()
            optionText2.isChecked = true
            answer = optionText2.text.toString()

        }

        optionText3.setOnClickListener {
            clearAll()
            optionText3.isChecked = true
            answer = optionText3.text.toString()
        }

        optionText4.setOnClickListener {
            clearAll()
            optionText4.isChecked = true
            answer = optionText4.text.toString()
        }


        submitButton.setOnClickListener {
            val optionSelected : Boolean = (optionText1.isChecked or
                    optionText2.isChecked or
                    optionText3.isChecked or
                    optionText4.isChecked)

            if (isCorrect(questionBank.get(questionNo).answer)) {
                score = score + 10
                pointsText.text = "Points: " + score.toString()
            }

            if (questionNo < (questionBank.size - 1)) {
                if (optionSelected) {
                    questionNo++
                    display(questionNo)
                    errorText.text = ""
                } else {
                    errorText.text = "Please select an Option!"
                }

                if ((questionNo) == questionBank.size - 1) {
                    submitButton.text = "SUBMIT"
                }

            } else {
                if (optionSelected) {
                    intent2.putExtra("score", score.toString())
                    startActivity(intent2)
                    finish()
                } else {
                    errorText.text = "Please select an Option!"
                }

            }
            clearAll()
        }
    }
}

data class Question(
    var question : String,
    var optionA  : String,
    var optionB  : String,
    var optionC  : String,
    var optionD  : String,
    var answer   : String
    )
