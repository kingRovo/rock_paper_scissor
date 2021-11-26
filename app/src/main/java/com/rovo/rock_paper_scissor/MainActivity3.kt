package com.rovo.rock_paper_scissor


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.TextView
import android.widget.ImageView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val userChoice = intent.getStringExtra(EXTRA_MESSAGE)
        val userImage = findViewById<ImageView>(R.id.imageView)
        var imgResId = R.drawable.rock

        when(userChoice){
            "Rock" -> imgResId = R.drawable.rock
            "Paper" -> imgResId = R.drawable.paper
            "Scissors" -> imgResId = R.drawable.scissors
            else -> R.drawable.rock
        }
        userImage.setImageResource(imgResId)


        fun generateChoice(): String {
            val list = (0..2)
            val choice = list.shuffled().take(1)[0]
            val rps = arrayOf("Rock", "Paper", "Scissors")
            return rps.elementAtOrElse(choice) { index -> "The value for index $index is undefined" }
        }

        val compChoice = generateChoice()
        val compImage = findViewById<ImageView>(R.id.imageView4)
        var imgResId2 = R.drawable.rock

        //When compChoice == "Rock", "Paper", or "Scissors". Else statement needed
        when(compChoice){
            "Rock" -> imgResId2 = R.drawable.rock
            "Paper" -> imgResId2 = R.drawable.paper
            "Scissors" -> imgResId2 = R.drawable.scissors
            else -> R.drawable.rock
        }
        compImage.setImageResource(imgResId2)


        var display: String

        //When true. This replaces nested if and else if statements.
        when{
            (userChoice == "Rock"  && compChoice == "Paper") -> display = "You Lose!"
            (userChoice == "Paper"  && compChoice == "Scissors")  -> display = "You Lose!"
            (userChoice == "Scissors"  && compChoice == "Rock") -> display = "You Lose!"
            (userChoice == compChoice ) -> display = "Draw!"
            else -> display = "You Win!"
        }

        //Place the value of display in the TextView
        findViewById<TextView>(R.id.textView5).apply {
            text = display
        }
    }
}