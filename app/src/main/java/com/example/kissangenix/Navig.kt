package com.example.kissangenix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_navig.*


class Navig : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navig)
        val drawerLayout: DrawerLayout = draweLayout
        val navView : NavigationView = nav_view

        toggle = ActionBarDrawerToggle(this,drawerLayout,0,0)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.about-> Toast.makeText(applicationContext,"Clicked About", Toast.LENGTH_SHORT).show()
                R.id.share-> Toast.makeText(applicationContext,"Clicked share", Toast.LENGTH_SHORT).show()
                R.id.profile-> startActivity(Intent(this, profileactivity::class.java))

                R.id.logout-> Toast.makeText(applicationContext,"Clicked logout", Toast.LENGTH_SHORT).show()
                R.id.notifications-> Toast.makeText(applicationContext,"Clicked notification",
                    Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}