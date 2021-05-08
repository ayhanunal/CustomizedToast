package com.ayhanunal.customizedtoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ayhanunal.customizedtoast.components.Duration
import com.ayhanunal.customizedtoast.components.Gravity
import com.ayhanunal.customizedtoast.components.myCustomToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Toast(this).myCustomToast("MY CUSTOM TOAST MSG", this, _duration = Duration.LONG, _gravity = Gravity.TOP)

    }
}