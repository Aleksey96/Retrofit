package com.alexey.retrofit.reset


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.alexey.retrofit.*
import com.rengwuxian.materialedittext.MaterialEditText


class ResetAccountViewFragment : Fragment(), ResetAccountView {
    private lateinit var tvSignIn: TextView
    private lateinit var tvInvalidData: TextView
    private lateinit var etPhoneNumber: MaterialEditText
    private lateinit var btnRegistration: Button
    private lateinit var presenterResetAccount: PresenterResetAccount

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.layout_forgotten_data, container, false)
        tvSignIn = view.findViewById(R.id.singIn)
        tvInvalidData = view.findViewById(R.id.invalidData)
        etPhoneNumber = view.findViewById(R.id.numberPhoneField)
        btnRegistration = view.findViewById(R.id.btnRegistration)
        presenterResetAccount = PresenterResetAccount(this)
        tvSignIn.setOnTouchListener(object : View.OnTouchListener {
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
        //etPhoneNumber.addTextChangedListener()
        btnRegistration.setOnClickListener {
            presenterResetAccount.checkValidationPhoneNumber()
        }
        return view
    }

    override fun onPause() {
        presenterResetAccount.onPause()
        super.onPause()
    }

    override fun hideError() {
        tvInvalidData.doViewInvisible()
    }

    override fun clearPhoneNumber() {
        etPhoneNumber.setText("")
    }

    override fun showError() {
        clearPhoneNumber()
        tvInvalidData.doViewVisible()
    }

}

