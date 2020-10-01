package com.alexey.retrofit.registration


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.alexey.retrofit.MainActivity
import com.alexey.retrofit.R
import com.alexey.retrofit.doViewInvisible
import com.alexey.retrofit.doViewVisible
import com.rengwuxian.materialedittext.MaterialEditText


class RegistrationAccountFragment : Fragment(), RegistrationAccountView {
    private lateinit var etName: MaterialEditText
    private lateinit var etSurname: MaterialEditText
    private lateinit var etPhoneNumber: MaterialEditText
    private lateinit var etEmail: MaterialEditText
    private lateinit var etLoginRegistration: MaterialEditText
    private lateinit var etPass: MaterialEditText
    private lateinit var etExistAccount: TextView
    private lateinit var btnRegistration: Button
    private lateinit var etInvalidData: TextView
    private lateinit var presenterRegistrationAccount: PresenterRegistrationAccount

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.layout_registration, container, false)
        etName = view.findViewById(R.id.nameField)
        etSurname = view.findViewById(R.id.surnameField)
        etPhoneNumber = view.findViewById(R.id.numberPhoneField)
        etEmail = view.findViewById(R.id.emailFieldReg)
        etLoginRegistration = view.findViewById(R.id.loginField)
        etPass = view.findViewById(R.id.passField)
        etExistAccount = view.findViewById(R.id.textExistAccount)
        btnRegistration = view.findViewById(R.id.button_registration)
        etInvalidData = view.findViewById(R.id.messageInvalidData)
        presenterRegistrationAccount = PresenterRegistrationAccount(this)

        etExistAccount.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                fragmentManager!!.beginTransaction()
                    .replace(
                        R.id.container,
                        MainActivity.fragmentSignIn
                    )
                    .addToBackStack(null)
                    .commit()
                return true
            }
        })

        btnRegistration.setOnClickListener {}
        return view
    }

    override fun onPause() {
        etInvalidData.doViewInvisible()
        super.onPause()
    }

    override fun showErrorEmptyView() {
        etInvalidData.doViewInvisible()
    }

    override fun showErrorFormatPhone(view: MaterialEditText) {
        etInvalidData.doViewVisible()
        clearEditText(view)
    }

    override fun clearEditText(view: MaterialEditText) {
        view.setText("")
    }
}
