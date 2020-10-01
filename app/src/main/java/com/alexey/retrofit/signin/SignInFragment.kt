package com.alexey.retrofit.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.alexey.retrofit.MainActivity
import com.alexey.retrofit.R
import com.alexey.retrofit.doViewInvisible
import com.alexey.retrofit.doViewVisible
import com.alexey.retrofit.reset.ResetAccountViewFragment
import com.rengwuxian.materialedittext.MaterialEditText

class SignInFragment : Fragment(), SignInView {
    private lateinit var singRegistration: TextView
    private lateinit var forgotAccount: TextView
    private lateinit var messageError: TextView
    private lateinit var btnSignIn: Button
    private lateinit var dataForgotFragment: ResetAccountViewFragment
    private lateinit var presenterSignIn: PresenterSignIn
    private lateinit var loginSignIn: MaterialEditText
    private lateinit var passSignIn: MaterialEditText

    override fun changeLoginHelperText(message: String) {
        loginSignIn.setHelperText(message)
    }

    override fun changePassWordHelperText(message: String) {
        passSignIn.setHelperText(message)
    }

    override fun clearFields() {
        passSignIn.setText("")
        loginSignIn.setText("")
    }

    override fun hideErrorInvalidData() {
        messageError.doViewInvisible()
    }

    override fun showErrorInvalidData() {
        messageError.doViewVisible()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataForgotFragment = ResetAccountViewFragment()
        val view = inflater.inflate(R.layout.layout_sign_in, container, false)
        btnSignIn = view.findViewById(R.id.buttonSignIn)
        singRegistration = view.findViewById(R.id.signInRegistration)
        forgotAccount = view.findViewById(R.id.textExistAccount)
        loginSignIn = view.findViewById(R.id.loginFieldSign)
        passSignIn = view.findViewById(R.id.passField)
        messageError = view.findViewById(R.id.invalidData)

        btnSignIn.setOnClickListener {
            presenterSignIn.checkValidationData(
                passSignIn.text.toString(),
                loginSignIn.text.toString()
            )
        }


        singRegistration!!.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                fragmentManager!!.beginTransaction()
                    .replace(
                        R.id.container,
                        MainActivity.fragmentRegistration
                    )
                    .addToBackStack(null)
                    .commit()
                return true
            }
        })

        forgotAccount!!.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                fragmentManager!!.beginTransaction()
                    .replace(R.id.container, dataForgotFragment)
                    .addToBackStack(null)
                    .commit()
                return true
            }

        })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenterSignIn = PresenterSignIn(this)

    }

    override fun onPause() {
        presenterSignIn.onPause()
        super.onPause()
    }
}
