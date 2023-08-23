package com.example.ex_contact.alima

import android.app.Activity
import android.widget.ImageButton
import com.example.ex_contact.R

fun Activity.slideLeft() {
    overridePendingTransition(R.anim.slide_left_enter, R.anim.slide_left_exit)
}

fun Activity.slideRight() {
    overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
}
fun imgPressed(btn: ImageButton){
    btn.setOnClickListener{
        btn.isSelected = btn.isSelected != true

    }

}