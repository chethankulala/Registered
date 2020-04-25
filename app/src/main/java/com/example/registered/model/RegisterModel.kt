package com.example.registered.model

import android.util.Patterns
import java.util.regex.Pattern

class RegisterModel (val name: String, val phone: String, val email:String, val pass: String){

    val isValidPhone: Boolean
        get() = phone.length == 10

    val isValidEmail: Boolean
        get() {
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches())
                return true
            return false
        }

    val isPasswordValid: Boolean
        get() = pass.length >= 6
}