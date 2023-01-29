package com.example.kissangenix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_crop.*

class crop : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crop)
        getSupportActionBar()?.hide();

        var list = mapOf<String,String>(
            "Bagalkot" to "Sorghum, Maize, Wheat, Groundnut, Sunflower, Greengram,Redgram, Bengalgram, Sugarcane and Cotton",
            "Bellari"  to "cotton, jowar, groundnuts, rice, sunflowers and cereals",
            "Belagavi" to "jowar, maize, paddy, wheat, bajra, grams, tur, groundnut, sunflower, sugarcane, cotton, tobacco ",
            "Bengaluru" to "ragi, rice, groundnut, sugarcane, castor, grapes, mulberry",
            "Bidar" to "greengram, Bengalgram, Blackgram, Paddy, Groundnut, Wheat, Redgram, Sugarcane and chillies",
            "Chamarajanagar" to "sugarcane,cotton,ragi",
            "Chikkaballapura" to "mango, grapes, pomegranate, sapota, guava, papaya, banana and citrus and cut flowers",
            "Chikkamagaluru" to "groundnut, sesamum, sunflower, castor,sugarcane, cotton, and tobacco",
            "Chitradurga" to "Millets,sugarcane,fruits",
            "DakshinaKannada" to "Arecanut, Coconut, Pepper, Cashew, Banana, Vegetables, and Flower crops like Jasmine",
            "Davangere" to "sugarcane, rice and maize ",
            "Dharwad" to "Mango, Sapota, Banana, Guava, Papaya, Coconut, Cashew and Chilly",
            "Gadag" to "Major Cereals – Wheat, Jower and Maize\n" +
                    "Pulses – Bengal gram, Green gram\n" +
                    "Oil Seeds – Groundnut, Sunflower\n" +
                    "Commercial Crops – Sugarcane and Cotton\n",
            "Hassan" to "Coffee, Black Pepper, Potato, Paddy and Sugarcane ",
            "Haveri" to "Maize, paddy, jowar and ragi",
            "Gulbarga" to "jowar, bajra, gram, tur, groundnut, sunflower and sugarcane.",
            "Kodagu" to "Paddy,Coffee, Cardamom, Pepper and Oranges",
            "Kolar" to " finger millet, groundnut and pulses,paddy, mulberry, sugarcane, potato, Mango and Grapes",
            "Koppal" to "Jawar, Bajra, Wheat, Maize, Paddy, Horsegram, Greengram, Cowpeas,Groundnut, Till, Cotton, Niger seeds, Castor, Sunflower, Sugarcane etc.",
            "Mandya" to "Ragi,Rice,Sugarcane,pulses,horsegram,tur,greengram,cowpea,blackgram and oilseeds",
            "Mysuru" to "cotton, grams, groundnut, jowar, maize, ragi, rice, sugarcane, sunflower and tur.",
            "Raichuru" to "rice, cotton, groundnut and pulses.",
            "Ramanagara" to "Mango, Coconut, Banana, Papaya, Arecanut, Sapota, Pomegranate, Tomato, Brinjal, Chilli, Aster, Jasmine, Chrysanthemum etc.",
            "Shivamogga" to "paddy, arecanut, cotton, maize, oil seeds, cashewnut, pepper, chili, ginger, Ragi.",
            "Tumakuru" to "Coconut, Arecanut, Banana, Mango, Sapota, Pomegranate, Tomato, Brinjal, Chilli, Aster, Jasmine, Chrysanthemum etc.",
            "Udupi" to "Coconut, Arecanut, Cashew, Rubber; Spice crops viz., Pepper, Ginger, Turmeric; Fruit crops namely Mango, Pineapple, Sapota & Banana;",
            "Uttarakannada" to "cashew, pineapple, coconut ",
            "Vijaypura" to "Sugarcane, sorghum, bajra, maize, red gram, groundnut, sunflower and cotton ",
            "Yadgiri" to "jowar, red gram, sunflower and groundnut.",
        )
        suggest.setOnClickListener {
            Log.d("$district","${sug.text}")
            var state = state.text.toString()
            var district = district.text.toString()
            if(list.containsKey(district))
            sug.text = list.getValue(district).toString()
            else
                Toast.makeText(this,"Enter a Valid District",Toast.LENGTH_SHORT).show()
            Log.d("$district","${sug.text}")
        }
        mapbtn.setOnClickListener {
            val intent = Intent(this,MapsActivity::class.java)
            startActivity(intent)
        }
    }
}