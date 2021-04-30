package com.jesse.week_five_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class ResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val profileName = findViewById<TextView>(R.id.tvInputName)
        val profilePhoneNumber = findViewById<TextView>(R.id.tvInputPhone)
        val profileEmail = findViewById<TextView>(R.id.tvInputEmail)
        val profileGender = findViewById<TextView>(R.id.tvInputGender)

        val username = intent.getStringExtra("userName")
        val userPhoneNumber = intent.getStringExtra("userPhone")
        val userEmail = intent.getStringExtra("userEmail")
        val userGender = intent.getStringExtra("gender")
        profileName.text = username
        profilePhoneNumber.text = userPhoneNumber
        profileEmail.text = userEmail
        profileGender.text = userGender
    }
}