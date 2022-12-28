package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        result_username.text = userName

        val correctAns = intent.getIntExtra(Constants.CORRECT_ANSWER,0)
        val TotalQues = intent.getIntExtra(Constants.TOTAL_QUES,0)

        result_testscore.text = "Your Score is "+"$correctAns" + " out of " + "$TotalQues"

        result_button.setOnClickListener{
            val intent = Intent(this@ResultActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}