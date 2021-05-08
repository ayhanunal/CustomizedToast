package com.ayhanunal.customizedtoast.components

import android.app.Activity
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.ayhanunal.customizedtoast.R
import java.time.Duration

enum class Duration{
    LONG,
    SHORT,
}

enum class Gravity{
    BOTTOM,
    CENTER,
    TOP,
}


fun Toast.myCustomToast(
    message: String,
    activity: Activity,
    _duration: com.ayhanunal.customizedtoast.components.Duration = com.ayhanunal.customizedtoast.components.Duration.LONG, //default duration LONG
    _gravity: com.ayhanunal.customizedtoast.components.Gravity = com.ayhanunal.customizedtoast.components.Gravity.CENTER,

)
{
    //Connects with the created custom_toast.xml activity
    val layout = activity.layoutInflater.inflate (
        R.layout.custom_toast,
        activity.findViewById(R.id.toast_container)
    )

    // set the text of the TextView of the message
    val textView = layout.findViewById<TextView>(R.id.toast_msg)
    textView.text = message

    // use the application extension function
    this.apply {



        when(_gravity){
            com.ayhanunal.customizedtoast.components.Gravity.TOP -> setGravity(Gravity.TOP, 0, 160)
            com.ayhanunal.customizedtoast.components.Gravity.CENTER -> setGravity(Gravity.CENTER, 0, 40)
            com.ayhanunal.customizedtoast.components.Gravity.BOTTOM -> setGravity(Gravity.BOTTOM, 0, 40)
            else -> {
                setGravity(Gravity.CENTER, 0, 40)
            }
        }

        duration = if (_duration == com.ayhanunal.customizedtoast.components.Duration.LONG) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
        view = layout
        show()
    }
}