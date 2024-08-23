package app.ishizaki.dragon.anzan

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ishizaki.dragon.anzan.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val randomNumber1 = Random.nextInt(1000)
        val randomNumber2 = Random.nextInt(1000)

        binding.number1Text.text = randomNumber1.toString()
        binding.number2Text.text = randomNumber2.toString()

        val randomOperator = Random.nextInt(2)
        var operatorText = ""
        var correctAnswer = 0

        if (randomOperator == 0){
            operatorText = " + "
            binding.signText.text = operatorText
            correctAnswer = randomNumber1 + randomNumber2
        } else {
            operatorText = " - "
            binding.signText.text = operatorText
            correctAnswer = randomNumber1 - randomNumber2

        }

        binding.checkButton.setOnClickListener {

            val yourAnswer = binding.inputText.text.toString()
            val questionText = randomNumber1.toString() + operatorText + randomNumber2.toString()

            if (yourAnswer.isNotEmpty()){
                val answerIntent = Intent(this, AnswerActivity::class.java)
                answerIntent.putExtra("question", questionText)
                answerIntent.putExtra("your_answer", yourAnswer)
                answerIntent.putExtra("correct", correctAnswer.toString())

                startActivity(answerIntent)
                finish()
            }

        }

    }
}