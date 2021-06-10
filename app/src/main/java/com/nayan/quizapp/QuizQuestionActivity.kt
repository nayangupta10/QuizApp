package com.nayan.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.quiz_question_activity.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    var mCurrentPosition = 1
    var mQuestionList: ArrayList<Question>? = null
    var mSelectedOptionList: Int = 0
    var mCorrectAnswers: Int=0
    var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_question_activity)

        mUserName=intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestion()
        setQuestion()

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)
    }

    private fun setQuestion() {
        val question: Question? = mQuestionList?.get(mCurrentPosition - 1)

        defaultOptionView()
        if (mCurrentPosition == mQuestionList!!.size)
            btnSubmit.text = "FINISH"
        else
            btnSubmit.text = "SUBMIT"


        progressBar.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition" + "/" + "${progressBar.max}"
        tvQuestion.text = question!!.question
        ivImage.setImageResource(question.image)
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour
    }

    private fun defaultOptionView() {
        val optionView = ArrayList<TextView>()
        optionView.add(0, tvOptionOne)
        optionView.add(1, tvOptionTwo)
        optionView.add(2, tvOptionThree)
        optionView.add(3, tvOptionFour)

        for (option in optionView) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvOptionOne -> selectedOptionView(tvOptionOne, 1)
            R.id.tvOptionTwo -> selectedOptionView(tvOptionTwo, 2)
            R.id.tvOptionThree -> selectedOptionView(tvOptionThree, 3)
            R.id.tvOptionFour -> selectedOptionView(tvOptionFour, 4)
            R.id.btnSubmit -> {
                if (mSelectedOptionList == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                          val intent= Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList!!.size)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            startActivity(intent)
                            finish()
                        }

                    }
                } else {
                    val question: Question? = mQuestionList!![mCurrentPosition - 1]
                    if (question!!.correctAnswer != mSelectedOptionList) {
                        answerView(mSelectedOptionList, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size)
                        btnSubmit.text = "FINISH"
                    else
                        btnSubmit.text = "GO TO NEXT QUESTION"
                    mSelectedOptionList = 0
                }

            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            2 -> tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
            3 -> tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)
            4 -> tvOptionFour.background = ContextCompat.getDrawable(this, drawableView)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionList = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background =
            ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }
}