package com.example.kissangenix

import android.content.Intent
import android.icu.util.TimeUnit
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_dashboard.signup
import kotlinx.android.synthetic.main.activity_loginpage.*
import javax.xml.datatype.DatatypeConstants.SECONDS

class dashboard : AppCompatActivity()
{
    lateinit var auth: FirebaseAuth
    lateinit var storedVerificationId:String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
     lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar?.hide()


        signup.setOnClickListener {
            val name = name.text.toString()
            val age = age.text.toString().toInt()
            val occupation = occupation.text.toString()
            val phoneno = phoneno.text.toString()
            val password = password.text.toString()
            Log.d("Name", "$name")
            Log.d("Uid", "$phoneno")

            database = FirebaseDatabase.getInstance().getReference("Users")

            val user = user(name, age, occupation, phoneno, password)
            database.child(name).setValue(user).addOnSuccessListener {
                login()
                Toast.makeText(this, "Welcome To Kissan Genix", Toast.LENGTH_SHORT).show()
            }
        }
        login.setOnClickListener {
            val intent = Intent(this, loginpage::class.java)
            startActivity(intent)
        }
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                startActivity(Intent(applicationContext, content::class.java))
                finish()
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_LONG).show()
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {

                Log.d("TAG", "onCodeSent:$verificationId")
                storedVerificationId = verificationId
                resendToken = token
                var intent = Intent(applicationContext, otp::class.java)
                intent.putExtra("storedVerificationId", storedVerificationId)
                startActivity(intent)
            }
        }

    }
    private fun login() {
        var number=phoneno.text.toString().trim()

        if(!number.isEmpty()){
            number="+91"+number
            sendVerificationcode (number)
        }else{
            Toast.makeText(this,"Enter mobile number",Toast.LENGTH_SHORT).show()
        }
    }
    private fun sendVerificationcode(number: String) {
        auth=FirebaseAuth.getInstance()
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(number) // Phone number to verify
            .setTimeout(60L, java.util.concurrent.TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this) // Activity (for callback binding)
            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
}


