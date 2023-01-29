package com.example.kissangenix


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*


class feed : AppCompatActivity() {

    private lateinit var dbref:DatabaseReference
    private lateinit var feedRecyclerView: RecyclerView
    private lateinit var feedArrayList: ArrayList<feedDetails>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        getSupportActionBar()?.hide();
        feedRecyclerView = findViewById(R.id.datafeed)
        feedRecyclerView.layoutManager = LinearLayoutManager(this)
        feedRecyclerView.setHasFixedSize(true)

        feedArrayList = arrayListOf<feedDetails>()
        getUserData()
    }

    private fun getUserData() {

        dbref = FirebaseDatabase.getInstance().getReference("Rent")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists())
                {
                    for(userSnapshot in snapshot.children)
                    {
                        val user = userSnapshot.getValue(feedDetails::class.java)
                        feedArrayList.add(user!!)
                    }
                    feedRecyclerView.adapter = myadapter(feedArrayList)
                    }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}