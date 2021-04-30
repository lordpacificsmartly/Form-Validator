package com.jesse.week_five_task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.OnClickListener
import android.widget.*
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText



class MainActivity : AppCompatActivity() {

    //Declare variables
    private lateinit var name :TextInputEditText
    private lateinit var phoneNumber : TextInputEditText
    private lateinit var email : TextInputEditText
    private lateinit var genderSelection :AutoCompleteTextView
    private lateinit var btnRegister : Button






        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize variables to retrieve ids
        name = findViewById(R.id.tvRegisterName)
        phoneNumber =findViewById(R.id.tvRegisterPhone)
        email = findViewById(R.id.tvRegisterEmail)
        genderSelection = findViewById(R.id.autoComplete)
        btnRegister = findViewById(R.id.button)


        //Set the object Tools to implement desired color on the status bar
        Tools.setSystemBarLight(this)
        Tools.setSystemBarColor(this, R.color.white)


            //Initialize variable to retrieve items on gender string array
            //Set ArrayAdapter to dropdown item and string array
            val gender = resources.getStringArray(R.array.gender)
            val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, gender)
            findViewById<AutoCompleteTextView>(R.id.autoComplete).setAdapter(arrayAdapter)



        //
            phoneNumber.doOnTextChanged { text, _, _, _ ->
            phoneNumber.error = null
            phoneNumber.display
            Log.d("MainActivity", "onCreate: $text")
            if(text!!.length > 13 || text!!.length < 11){
                phoneNumber.error = "Invalid, phone must start with either 0 or 234"
            }
        }


        btnRegister.setOnClickListener( OnClickListener {
            val username = name.text.toString()
            val userPhoneNumber = phoneNumber.text.toString()
            val userEmail = email.text.toString()
            val userGender = genderSelection.text.toString()
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("userName", username)
            intent.putExtra("userPhone", userPhoneNumber)
            intent.putExtra("userEmail",userEmail)
            intent.putExtra("gender", userGender)

            if (Validate.validateRegistrationInput(username, userPhoneNumber, userEmail, userGender) && Validate.validateEmail(userEmail)){
                startActivity(intent)
            }else{
                phoneNumber.error = "Invalid number"
                email.error = "Invalid Email"
                Toast.makeText(this, "Phone and email must be correct", Toast.LENGTH_SHORT).show()
            }

        }
        )


    }
}





