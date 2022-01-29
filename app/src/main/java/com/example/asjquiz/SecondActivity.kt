package com.example.asjquiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var PointsText : TextView
    private lateinit var QsNoText : TextView
    private lateinit var QSText : TextView
    private lateinit var OptionText1 : RadioButton
    private lateinit var OptionText2 : RadioButton
    private lateinit var OptionText3 : RadioButton
    private lateinit var OptionText4 : RadioButton
    private lateinit var submitButton : Button

    private lateinit var QuestionBank : ArrayList<Question>
    private var QuestionNo : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        PointsText = findViewById(R.id.textView3)
        QsNoText = findViewById(R.id.textView4)
        QSText = findViewById(R.id.textView5)

        OptionText1 = findViewById(R.id.radioButton1)
        OptionText2 = findViewById(R.id.radioButton2)
        OptionText3 = findViewById(R.id.radioButton3)
        OptionText4 = findViewById(R.id.radioButton4)

        submitButton = findViewById(R.id.button2)

        QuestionBank = ArrayList()
        QuestionNo = 0



        val intent2 = Intent (this ,ThirdActivity::class.java )





        setupquestion()
        initListeners()
        display(QuestionNo)

    }

    @SuppressLint("SetTextI18n")
    fun display(index : Int) {

        QsNoText.text = "Question no: " + (index + 1).toString()
        QSText.text = QuestionBank.get(index).question
        OptionText1.text = QuestionBank.get(index).optionA
        OptionText2.text = QuestionBank.get(index).optionB
        OptionText3.text = QuestionBank.get(index).optionC
        OptionText4.text = QuestionBank.get(index).optionD

    }


    fun setupquestion() {
        QuestionBank.add(
            Question(
                "How do we interpret a dummy variable coefficient?  " ,
                "a. The difference between two means" ,
                "b. The difference between two coefficients" ,
                "c. The difference between two R-square values" ,
                "d. None of the above" ,
                "a. The difference between two means"
            )
        )

        QuestionBank.add(
            Question(
                "'OS' computer abbreviation usually means?" ,
                "a. Order of Significance" ,
                "b. Open Software" ,
                "c. Operating System" ,
                "d. Optical Sensor" ,
                "a. Operating System"
            )
        )

        QuestionBank.add(
            Question(
                "'.MOV' extension refers usually to what kind of file?" ,
                "a. Image file" ,
                "b. Animation/movie file" ,
                "c. Audio file" ,
                "d. MS Office document" ,
                "a. Animation/movie file"
            )
        )

        QuestionBank.add(
            Question(
                "What does SSL stand for?" ,
                "a. Secure Socket Layer" ,
                "b. System Socket Layer" ,
                "c. Superuser System Login" ,
                "d. Secure System Login" ,
                "a. Secure Socket Layer"
            )
        )


    }

    fun initListeners() {

        PointsText.setOnClickListener {

        }

        QSText.setOnClickListener {

        }

        OptionText1.setOnClickListener {

        }

        OptionText2.setOnClickListener {

        }

        OptionText3.setOnClickListener {

        }

        OptionText4.setOnClickListener {

        }

        submitButton.setOnClickListener {
            QuestionNo++
            display(QuestionNo)
        }

    }
}

data class Question(
    var question : String ,
    var optionA : String ,
    var optionB : String ,
    var optionC : String ,
    var optionD : String ,
    var answer : String

)