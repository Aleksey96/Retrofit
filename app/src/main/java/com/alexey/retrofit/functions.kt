package com.alexey.retrofit

import android.content.Context
import android.view.View
import android.widget.Toast

fun View.doViewVisible() {
    if (visibility == View.INVISIBLE) {
        visibility = View.VISIBLE
    }
}

fun View.doViewInvisible() {
    if (visibility == View.VISIBLE)
        visibility = View.INVISIBLE
}

fun Context.toast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

