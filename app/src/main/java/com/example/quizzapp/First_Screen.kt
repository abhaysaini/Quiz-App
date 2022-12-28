package com.example.quizzapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_first_screen.*

class First_Screen : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswer:Int = 0
    private var mUserName:String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)

        mQuestionList = Constants.getQuestion();
        setQuestion()

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)
        button_submit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.option1 -> {
                selectedOptionView(option1, 1)
            }
            R.id.option2 -> {
                selectedOptionView(option2, 2)
            }
            R.id.option3 -> {
                selectedOptionView(option3, 3)
            }
            R.id.option4 -> {
                selectedOptionView(option4, 4)
            }
            R.id.button_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this@First_Screen,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER,mCorrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUES,mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_border_bg)
                    }
                    else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        button_submit.text = "FINISH"
                    } else {
                        button_submit.text = "Move to Next Question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }

    }

    private fun setQuestion() {

        val question = mQuestionList!![mCurrentPosition - 1]
        defaultOptionView()

        if (mCurrentPosition == mQuestionList!!.size) {
            button_submit.text = "FINISH"
        } else {
            button_submit.text = "SUBMIT"
        }

        progress_Bar.progress = mCurrentPosition
        test_score.text = "$mCurrentPosition" + "/" + progress_Bar.max
        question_tv.text = question.questions
        image_view.setImageResource(question.image)
        option1.text = question.optionOne
        option2.text = question.optionTwo
        option3.text = question.optionThree
        option4.text = question.optionFour
    }

    fun selectedOptionView(tv: TextView, selectedoptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedoptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this@First_Screen, R.drawable.selected_option_border_bg)
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                option1.background = ContextCompat.getDrawable(this@First_Screen, drawableView)
            }
            2 -> {
                option2.background = ContextCompat.getDrawable(this@First_Screen, drawableView)
            }
            3 -> {
                option3.background = ContextCompat.getDrawable(this@First_Screen, drawableView)
            }
            4 -> {
                option4.background = ContextCompat.getDrawable(this@First_Screen, drawableView)
            }
        }
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, option1)
        options.add(1, option2)
        options.add(2, option3)
        options.add(3, option4)
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this@First_Screen, R.drawable.default_border_bg)
        }
    }
}























