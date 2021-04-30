package com.jesse.week_five_task


// Create class to validate phone number and email,
 //this class contains two methods wrapped in a companion object to ease instantiation.


object Validate {
    lateinit var error: Error

    fun validatePhoneNumber(phoneNumber : String) : Boolean{
        val pattern = Regex("^(0|234)((70)|([89][01]))[0-9]{8}\$")
        return pattern.matches(phoneNumber)
    }
    fun validateEmail(email: String): Boolean{
        val  pattern = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
        return pattern.matches(email)
    }


     // the input is not valid if....
     // the username/email/gender/phone number is empty
     // the phone number is greater than 11
     // the phone is less than 11
     // phone number must start with 0 or 234

    fun validateRegistrationInput( userName:String, phoneNumber: String, email: String, gender:String): Boolean{
        if (userName.trim().isEmpty()) {
            error = Error("username", "Username cannot be empty")
            return false
        } else if (!validatePhoneNumber(phoneNumber)) {
            error = Error("phone", "Phone number is incorrect")
            return false
        }
        else if (!validateEmail(email)) {
            error = Error("email", "Invalid email")
            return false
        }else if (gender.trim().isEmpty()) {
            error = Error("gender", "Gender cannot be empty")
            return false
        }
        return true
    }
}


