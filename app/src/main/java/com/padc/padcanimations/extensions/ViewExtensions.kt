package com.padc.padcanimations.extensions

import android.view.View

fun View.toggleVisibility() {
    if (this.isShownOnScreen())
        this.hide()
    else
        this.show()
}

fun View.hide(){
    visibility = View.GONE
}

fun View.show(){
    visibility = View.VISIBLE
}

fun View.isShownOnScreen() : Boolean{
    return visibility == View.VISIBLE
}