package com.example.kissangenix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_loginpage.*


class loginpage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)
        supportActionBar?.hide();
        getSupportActionBar()?.hide();
        enter.setOnClickListener {
            val intent = Intent(this, content::class.java)
            startActivity(intent)
        }

    }

}