package com.example.kissangenix

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_content.*
import kotlinx.android.synthetic.main.activity_loginpage.*

class content : AppCompatActivity()
{

    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        getSupportActionBar()?.hide();
        btn1.setOnClickListener {
            val intent = Intent(this, Rent::class.java)
            startActivity(intent)
        }
        btn3.setOnClickListener {
            val intent = Intent(this, equip::class.java)
            startActivity(intent)
        }
        btn4.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        btn5.setOnClickListener {
            val intent = Intent(this, webView::class.java)
            startActivity(intent)
        }
        btn6.setOnClickListener {
            val intent = Intent(this, crop::class.java)
            startActivity(intent)
        }
        btn7.setOnClickListener {
            searchWeb("crop doctors near me")
        }
        btn8.setOnClickListener {
            val intent = Intent(this, Navig::class.java)
            startActivity(intent)
        }


    }
    private fun searchWeb(query: String) {
        val intent = Intent(Intent.ACTION_WEB_SEARCH)
        intent.putExtra(SearchManager.QUERY, query)
        startActivity(intent)
    }

}