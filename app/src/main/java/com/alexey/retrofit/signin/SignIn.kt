package com.alexey.retrofit.signin

interface SignIn {
    fun checkValidationData(pass: String, login: String)
    fun onPause()
}