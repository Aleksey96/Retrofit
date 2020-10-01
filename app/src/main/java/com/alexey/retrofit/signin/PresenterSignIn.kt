package com.alexey.retrofit.signin

import java.util.regex.Pattern


class PresenterSignIn(signInView: SignInView) : SignIn {
    private var signIn = signInView
    private val REGEX_CREDENTIAL =
        "([a-zA-Z0-9_\\S&&[^а-яА-Я]&&[^`~!@,;:'\"%№#&=\\-\\<\\>\\(\\)\\[\\]\\{\\}\\?\\*\\$\\^\\\\|\\/\\+\\.]]){8,15}"
    private val messageErrorContent =
        "Логин/пароль не должны содержать русских букв, пробелов, `~!@,;:'\"%№#&=-<>()[]{?*\$^|\\/+."

    override fun checkValidationData(pass: String, login: String) {
        val pattern: Pattern = Pattern.compile(REGEX_CREDENTIAL)
        if (pass.length in 8..15 && login.length >= 8) {
            val testPass = pattern.matcher(pass).matches()
            val testLogin = pattern.matcher(login).matches()
            signIn.changeLoginHelperText("")
            signIn.changePassWordHelperText("")
            if (testPass && testLogin) {
                signIn.hideErrorInvalidData()
                signIn.clearFields()
                //проверка на существование уз
                //после этого переход на другую активити

            } else {
                showError(
                    messageErrorContent, messageErrorContent
                )
            }
        } else {
            showError(
                "Длина логина должна быть не менее 8 символов",
                "Длина пароля должна быть 8 до 15 символов"
            )
        }
    }

    override fun onPause() {
        with(signIn) {
            clearFields()
            hideErrorInvalidData()
        }
    }

    private fun showError(loginMessageError: String, passwordMessageError: String) {
        with(signIn) {
            clearFields()
            showErrorInvalidData()
            changeLoginHelperText(loginMessageError)
            changePassWordHelperText(passwordMessageError)

        }
    }

}