package com.example.kissangenix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class profileactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    val btn = findViewById<Button>(R.id.backbutton)
        btn.setOnClickListener {
            val intent = Intent(this, Navig::class.java)
            startActivity(intent)
        }
    }
}
