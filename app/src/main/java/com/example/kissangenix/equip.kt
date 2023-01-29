package com.example.kissangenix

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_equip.*
import kotlinx.android.synthetic.main.activity_equip.phn
import kotlinx.android.synthetic.main.activity_equip.ra
import kotlinx.android.synthetic.main.activity_equip.rd
import kotlinx.android.synthetic.main.activity_equip.submit
import kotlinx.android.synthetic.main.activity_rent.*
import java.text.SimpleDateFormat
import java.util.*

class equip : AppCompatActivity() {
    lateinit var ImageUri : Uri
    lateinit var firebaseImage:FirebaseStorage
    lateinit var database:DatabaseReference
    lateinit var imageLink:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equip)
        getSupportActionBar()?.hide();
        select.setOnClickListener {
            selectImage()
        }
        upload.setOnClickListener {
            uploadImage()
        }
        submit.setOnClickListener {

            val eqpname = equipmentName.text.toString()
            val address = address.text.toString()
            val eqpage = age.text.toString()
            val rd = rd.text.toString()
            val ra = ra.text.toString()
            val phn = phn.text.toString()
            val pic = imageLink
            if(eqpname =="" || address=="" || eqpage=="" || rd=="" || ra =="" || phn == "") {
                Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show()
            }
            else {
                database = FirebaseDatabase.getInstance().getReference("Equipment")
                Log.d("Database","$database")
                val eqp = eqp(eqpname,address, eqpage, ra, rd, phn,pic)
                database.child(eqpname).setValue(eqp).addOnSuccessListener{
                    Toast.makeText(this, "Data Added Sucessfully", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }.addOnCompleteListener {
                    Log.d("Comp","completed")
                }
            }
        }
        plus.setOnClickListener {
            val intent = Intent(this,equipListActivity::class.java)
            startActivity(intent)
        }
    }
    fun selectImage()
    {
        val intent = Intent()
        intent.type = "images/*"
        intent.action=Intent.ACTION_GET_CONTENT
        startActivityForResult(intent,100)
    }
    fun uploadImage()
    {
      val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Uploading....")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
        val now = Date()
        val fileName = formatter.format(now)
        firebaseImage= FirebaseStorage.getInstance()
        var storage = firebaseImage.getReference("Equip/$fileName")
        storage.putFile(ImageUri).addOnSuccessListener {
            Toast.makeText(this,"Successfully Uploaded",Toast.LENGTH_SHORT).show()
            if(progressDialog.isShowing)
                progressDialog.dismiss()
        }.addOnSuccessListener {

            val result = it.metadata!!.reference!!.downloadUrl;
            result.addOnSuccessListener {
                imageLink = it.toString()
            }
        }.addOnFailureListener{
            Toast.makeText(this,"Uploading Failed",Toast.LENGTH_SHORT).show()
            if(progressDialog.isShowing)
                progressDialog.dismiss()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==100 && resultCode== RESULT_OK) {
            ImageUri = data?.data!!
            pic.setImageURI(ImageUri)
        }
    }
}