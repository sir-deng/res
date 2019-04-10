package com.helen.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ImageView

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
       var logo:ImageView =  findViewById(R.id.logo);
        logo.setOnClickListener({
            Log.e("点击了","图片被点了")
        })
    }

}
