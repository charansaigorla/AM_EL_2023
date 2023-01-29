package com.example.kissangenix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_rent.*


class Rent : AppCompatActivity()
{
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rent)
        getSupportActionBar()?.hide();

        submit.setOnClickListener {

            val owner = owner.text.toString()
            val add = add.text.toString()
            val ra = ra.text.toString()
            val rd = rd.text.toString()
            val phn = phn.text.toString()
            if(owner =="" || add=="" || ra=="" || rd =="" || phn == "") {
                Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show()
            }
            else {
                database = FirebaseDatabase.getInstance().getReference("Rent")
                Log.d("Database","$database")
                val rentdetails = rentdetails(owner, add, ra, rd, phn)
                database.child(owner).setValue(rentdetails).addOnSuccessListener{
                    Toast.makeText(this, "Data Added Sucessfully", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }.addOnCompleteListener {
                    Log.d("Comp","completed")
                }
            }
        }
        flbtn.setOnClickListener {
            val intent = Intent(this, feed::class.java)
            startActivity(intent)
        }
    }
}