package com.alexey.retrofit.reset

import android.telephony.SmsManager

class PresenterResetAccount(resetAccountView: ResetAccountView) : ResetAccount {
    private val discardAccount = resetAccountView

    private fun sentSms(phoneNumber: String) {
        SmsManager.getDefault().sendTextMessage(
            phoneNumber, null,
            "Ваш логин:" + "\n" + "Ваш пароль", null, null
        )
    }

    override fun onPause() {
        discardAccount.clearPhoneNumber()
        discardAccount.hideError()
    }

    override fun checkValidationPhoneNumber() {
        TODO("Not yet implemented")
    }

}
