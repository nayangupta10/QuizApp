package com.nayan.quizapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.quiz_question_activity.*

class QuizQuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_question_activity)

        val questionList = Constants.getQuestion()
        Log.e("TAG", "QuestionList Size ${questionList.size}")

        val currentPosition = 1
        val question: Question? = questionList[currentPosition - 1]

        progressBar.progress = currentPosition
        tvProgress.text = "$currentPosition" + "/" + "${progressBar.max}"
        tvQuestion.text = question!!.question
        ivImage.setImageResource(question.image)
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour
    }
}