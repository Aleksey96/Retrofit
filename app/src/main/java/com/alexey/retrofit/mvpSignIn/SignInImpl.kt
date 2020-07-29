package com.alexey.retrofit


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 */
class SignIn : Fragment() {

    private val dataForgotFragment = DataForgot()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.layout_sign_in, container, false)
        val singRegistration=view.findViewById<TextView>(R.id.signInRegistration)
        val forgotAccount=view.findViewById<TextView>(R.id.textExistAccount)
        val btnSignIn=view.findViewById<Button>(R.id.buttonSignIn)
        val login=view.findViewById<com.rengwuxian.materialedittext.MaterialEditText>(R.id.emailField)
        val pass=view.findViewById<com.rengwuxian.materialedittext.MaterialEditText>(R.id.passField)

        btnSignIn.setOnClickListener{

        }

        singRegistration.setOnTouchListener(object :View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                fragmentManager!!.beginTransaction()
                    .replace(R.id.container, MainActivity.fragmentRegistration)
                    .addToBackStack(null)
                    .commit()
                return true
            }
        })

        forgotAccount.setOnTouchListener(object :View.OnTouchListener{
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
}
