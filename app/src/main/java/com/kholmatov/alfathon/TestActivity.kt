package com.kholmatov.alfathon

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.kholmatov.alfathon.com.kholmatov.alfathon.AlphaData
import com.kholmatov.alfathon.model.AlphaBets
import kotlin.random.Random

class TestActivity : ComponentActivity() {

    private lateinit var questionText: TextView
    private lateinit var arabicLetterText: TextView
    private lateinit var optionButtons: List<Button>
    private lateinit var backButton: Button

    private lateinit var alphaList: List<AlphaBets>
    private lateinit var correctAnswer: AlphaBets

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        // Find UI elements
        questionText = findViewById(R.id.questionText)
        arabicLetterText = findViewById(R.id.arabicLetter)
        optionButtons = listOf(
            findViewById(R.id.option1),
            findViewById(R.id.option2),
            findViewById(R.id.option3)
        )
        backButton = findViewById(R.id.backButton)

        // Back button logic
        backButton.setOnClickListener {
            finish()
        }

        // Load data and show first question
        alphaList = AlphaData.getAll(this)
        loadQuestion()
    }

    private fun loadQuestion() {
        // Get random options
        val options = alphaList.shuffled().take(3).toMutableList()
        correctAnswer = options.random()

        // Set text
        questionText.text = "What is the name of this letter?"
        arabicLetterText.text = correctAnswer.alphaArabic

        // Play letter sound


        // Set options
        options.shuffle()
        for (i in optionButtons.indices) {
            optionButtons[i].text = options[i].alphaName
            optionButtons[i].setOnClickListener {
                mediaPlayer?.release()
                mediaPlayer = MediaPlayer.create(this, options[i].alphaSound)
                mediaPlayer?.start()
                val isCorrect = options[i] == correctAnswer
                Toast.makeText(
                    this,
                    if (isCorrect) "✅ Correct!" else "❌ Wrong! It was ${correctAnswer.alphaName}.",
                    Toast.LENGTH_SHORT
                ).show()
                if (isCorrect) {
                    mediaPlayer?.setOnCompletionListener {
                        loadQuestion()
                    }
                }

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}