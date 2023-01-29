package com.example.kissangenix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.system.Os.open
import android.view.MenuItem
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.os.HandlerCompat.postDelayed
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

import java.util.*
class MainActivity : AppCompatActivity()
{
val splashscreen = 5000

    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide();
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation)

        imgView.animation = topAnimation


        Handler().postDelayed({
           val intent = Intent(this,dashboard::class.java)
            startActivity(intent)
            finish()
        },splashscreen.toLong())

    }

}


