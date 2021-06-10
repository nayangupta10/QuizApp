package com.nayan.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        btnStart.setOnClickListener {
            if (etName.text.toString().isEmpty())
                Toast.makeText(this, "Please enter your name!", Toast.LENGTH_SHORT).show()
            else
                startActivity(Intent(this, QuizQuestionActivity::class.java))
        }
    }
}