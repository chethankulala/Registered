package com.example.registered.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.registered.model.RegisterModel

class RegisterViewModel: ViewModel() {

    var name = MutableLiveData<String>()
    var phone = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var pass = MutableLiveData<String>()

    private var registerMutableLiveData: MutableLiveData<RegisterModel>? = null

    val register: MutableLiveData<RegisterModel>
        get() {
            if (registerMutableLiveData == null) {
                registerMutableLiveData = MutableLiveData()
            }
            return registerMutableLiveData as MutableLiveData<RegisterModel>
        }

    fun registerOnClick() {
        try {
            //Log.d("newPassword",newPassword.value!!.toString())
            //Log.d("newPassword",confirmPassword.value!!.toString())
            val registerModel = RegisterModel(name.value!!.toString(),phone.value!!.toString(),email.value!!.toString(),pass.value!!.toString())
            registerMutableLiveData!!.value = registerModel
        } catch (e: Exception) {
            Log.d("resetOnClick",e.toString())
        }
    }
}