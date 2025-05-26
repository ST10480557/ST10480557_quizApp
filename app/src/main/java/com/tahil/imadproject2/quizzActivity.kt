package com.tahil.imadproject2

import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class quizzActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quizz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvQuestion = findViewById<TextView>(R.id.textViewQuestion)
        val buttonNext = findViewById<Button>(R.id.buttonNext)
        val rbtnAnswers = findViewById<RadioGroup>(rbtngQuizAnswers)
        //Arrays of questions and Answers
        val Questions = arrayOf(
            "what is the chemical symbol for water?"
            "which planet is known as the red planet?"
            "what force keeps planets in orbit around the sun?"
            "what gas do plants absorb from the atmosphere?"
            "what is the boiling point of water at sea level?"
        )
        val answerChoices = arrayOf(
            arrayOf("A: H2O", "B: CO2", "C:O2"),
            arrayOf("A: Venus", "B: Mars", "C: Jupiter"),
            arrayOf("A: Magnetism", "B: Gravity", "C: Nuclear Forces"),
            arrayOf("A: Oxygen", "B:Carbon Dioxide", "C: Nitrogen"),
            arrayOf("A: 100C", "B: 0C", "C: 50C")
        )
        var userAnswers = arrayOfNulls<String>(5)
        val correctAnswers = arrayOf(
            "A: H20",
            "B: Mars",
            "B: Carbon Dioxide",
            "A: 100c"
        )
        var counter = 0
        //code logic
        while (counter < 5) {
            tvQuestion.text = Questions[counter]
            rbtnAnswers.clearCheck()
            for (i in 0 until rbtngAnswers.childCount) {
                val radioButton = rbtnAnswers.getChildAt(i) as RadioButton
                radioButton.text = answerChoices[counter][i]
            }
            var selectedOption = rbtngAnswers.checkRadioButtonId
            if (selectedOption != 1) {
                val selectedRbtn = findViewById<RadioButton>(selectedOption)
                userAnswers[counter] = selectedRbtn.text.toString()
            } else {

                Toast.makeText(this, "Plese pick a answer", Toast.LENGHT_SHORT).show()
            }
            counter++
        }
        else {
           buttonNext.setText("Finish")
    }
}//end of onCreate
}//end of QuizActivity