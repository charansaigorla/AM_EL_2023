package com.example.kissangenix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class equipListActivity : AppCompatActivity() {
    private lateinit var dbref: DatabaseReference
    private lateinit var feedRecyclerView: RecyclerView
    private lateinit var feedArrayList: ArrayList<equipdetails>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equip_list)
        getSupportActionBar()?.hide();
        feedRecyclerView = findViewById(R.id.equipList)
        feedRecyclerView.layoutManager = LinearLayoutManager(this)
        feedRecyclerView.setHasFixedSize(true)

        feedArrayList = arrayListOf<equipdetails>()
        getUserData()
    }
    private fun getUserData() {

        dbref = FirebaseDatabase.getInstance().getReference("Equipment")

        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists())
                {
                    for(userSnapshot in snapshot.children)
                    {
                        val user = userSnapshot.getValue(equipdetails::class.java)
                        feedArrayList.add(user!!)
                    }
                    feedRecyclerView.adapter = eqpAdapter(feedArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}