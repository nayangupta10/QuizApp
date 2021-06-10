package com.nayan.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val userName = intent.getStringExtra(Constants.USER_NAME)
        tvUserName.text = userName

        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        tvScore.text = "Your Score is $correctAnswers out of $totalQuestions"

        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}