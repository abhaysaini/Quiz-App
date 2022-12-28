package com.example.quizzapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        button1.setOnClickListener {
            if(NameText.text.toString().isEmpty()){
                Toast.makeText(this, "Enter Valid Name", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, First_Screen::class.java)
                intent.putExtra(Constants.USER_NAME,NameText.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}