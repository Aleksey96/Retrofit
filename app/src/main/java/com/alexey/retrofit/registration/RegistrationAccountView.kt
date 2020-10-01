package com.alexey.retrofit.registration

import com.rengwuxian.materialedittext.MaterialEditText

interface RegistrationAccountView {
    fun showErrorEmptyView()
    fun showErrorFormatPhone(view: MaterialEditText)
    fun clearEditText(view: MaterialEditText)
}