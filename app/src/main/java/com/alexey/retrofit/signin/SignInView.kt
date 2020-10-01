package com.alexey.retrofit.signin

import com.rengwuxian.materialedittext.MaterialEditText

interface SignInView {
    fun changeLoginHelperText(message: String)
    fun changePassWordHelperText(message: String)
    fun clearFields()
    fun hideErrorInvalidData()
    fun showErrorInvalidData()
}