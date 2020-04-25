package com.example.registered.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.registered.R
import com.example.registered.databinding.ActivityMainBinding
import com.example.registered.model.RegisterModel
import com.example.registered.viewmodel.RegisterViewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private var viewModel: RegisterViewModel? = null
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding!!.registerViewModel = viewModel

        inputValidate()
    }

    private fun inputValidate() {
        viewModel!!.register.observe(this, Observer{ registerModel: RegisterModel ->
            if (TextUtils.isEmpty(Objects.requireNonNull<RegisterModel>(registerModel).name)) {
                binding!!.name.error = "Enter Name"
                binding!!.name.requestFocus()
            } else if (TextUtils.isEmpty(Objects.requireNonNull<RegisterModel>(registerModel).phone)) {
                binding!!.phone.error = "Enter Phone Number"
                binding!!.phone.requestFocus()
            } else if (!registerModel.isValidPhone) {
                binding!!.phone.error = "Phone Number Is Not Valid"
                binding!!.phone.requestFocus()
            } else if (TextUtils.isEmpty(Objects.requireNonNull<RegisterModel>(registerModel).email)) {
                binding!!.email.error = "Enter Email Id"
                binding!!.email.requestFocus()
            } else if (!registerModel.isValidEmail) {
                binding!!.email.error = "Email Is Not Valid"
                binding!!.email.requestFocus()
            } else if (TextUtils.isEmpty(Objects.requireNonNull<RegisterModel>(registerModel).pass)) {
                binding!!.pass.error = "Enter Password"
                binding!!.pass.requestFocus()
            } else if (!registerModel.isPasswordValid) {
                binding!!.pass.error = "Enter Password with 6 or more character"
                binding!!.pass.requestFocus()
            } else {
                Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

