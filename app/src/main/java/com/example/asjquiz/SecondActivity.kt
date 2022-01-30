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
    private lateinit var intent2 : Intent
    private lateinit var errorText : TextView
    var answer : String = ""
    private var score : Int = 0

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

        errorText = findViewById(R.id.textView9)
        errorText.text = ""
        submitButton = findViewById(R.id.button2)
        submitButton.text = "NEXT"

        QuestionBank = ArrayList()
        QuestionNo = 0


        intent2 = Intent (this , ThirdActivity::class.java )








        setupquestion()
        initListeners()
        display(QuestionNo)

    }

    fun clearAll(){
        OptionText1.isChecked = false
        OptionText2.isChecked = false
        OptionText3.isChecked = false
        OptionText4.isChecked = false
    }

    fun isCorrect(value : String) : Boolean {
        return answer == value
    }

    @SuppressLint("SetTextI18n")
    fun display(index : Int) {

        QsNoText.text = "Question no: " + (index + 1).toString() + " of 5"
        QSText.text = "Q)  " + QuestionBank.get(index).question
        OptionText1.text = "a)  " + QuestionBank.get(index).optionA
        OptionText2.text = "b)  " + QuestionBank.get(index).optionB
        OptionText3.text = "c)  " + QuestionBank.get(index).optionC
        OptionText4.text = "d)  " + QuestionBank.get(index).optionD

    }


    fun setupquestion() {
        QuestionBank.add(
            Question(
                "How do we interpret a dummy variable coefficient?  " ,
                "The difference between two means" ,
                "The difference between two coefficients" ,
                "The difference between two R-square values" ,
                "None of the above" ,
                "The difference between two means"
            )
        )

        QuestionBank.add(
            Question(
                "'OS' computer abbreviation usually means?" ,
                "Order of Significance" ,
                "Open Software" ,
                "Operating System" ,
                "Optical Sensor" ,
                "Operating System"
            )
        )

        QuestionBank.add(
            Question(
                "'.MOV' extension refers usually to what kind of file?" ,
                "Image file" ,
                "Animation/movie file" ,
                "Audio file" ,
                "MS Office document" ,
                "Animation/movie file"
            )
        )

        QuestionBank.add(
            Question(
                "What does SSL stand for?" ,
                "Secure Socket Layer" ,
                "System Socket Layer" ,
                "Superuser System Login" ,
                "Secure System Login" ,
                "Secure Socket Layer"
            )
        )

        QuestionBank.add(
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

        PointsText.setOnClickListener {
            clearAll()

        }

        QSText.setOnClickListener {
            clearAll()
        }

        OptionText1.setOnClickListener {
            clearAll()
            OptionText1.isChecked = true
            answer = OptionText1.text.toString()
        }

        OptionText2.setOnClickListener {
            clearAll()
            OptionText2.isChecked = true
            answer = OptionText2.text.toString()

        }

        OptionText3.setOnClickListener {
            clearAll()
            OptionText3.isChecked = true
            answer = OptionText3.text.toString()
        }

        OptionText4.setOnClickListener {
            clearAll()
            OptionText4.isChecked = true
            answer = OptionText4.text.toString()
        }


        submitButton.setOnClickListener {

            if (isCorrect(QuestionBank.get(QuestionNo).answer)) {
                score = score + 10
                PointsText.text = "Points: " + score.toString()
            }

            if (!(QuestionNo < (QuestionBank.size - 2))) {
                submitButton.text = "SUBMIT"
            }


            if (QuestionNo < (QuestionBank.size - 1)) {

                var allUnchecked : Boolean = (OptionText1.isChecked or OptionText2.isChecked or OptionText3.isChecked or OptionText4.isChecked)
                if (allUnchecked) {
                    QuestionNo++
                    display(QuestionNo)
                    errorText.text = ""

                } else {
                    errorText.text = "Please select an Option!"
                }

            } else {
                intent2.putExtra("score" , score.toString())
                startActivity(intent2)
                finish()


            }
            clearAll()
        }

    }

}

data class Question(
    var question: String,
    var optionA: String,
    var optionB: String,
    var optionC: String,
    var optionD: String,
    var answer: String )
