package com.assignment.contact_app_validated

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.assignment.contact_app_validated.databinding.ActivityAddedUserBinding


class addedUser: AppCompatActivity() {
    lateinit var binding: ActivityAddedUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddedUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        binding.btnbutton2.setOnClickListener {
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
            clearErrors()
            validatecontact()
        }

    }


    fun validatecontact() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val number = binding.etPhoneNumber.text.toString()
        val email = binding.etEmail.text.toString()
        var error = false

        if (firstName.isBlank()) {
            binding.tilFirstName.error = "first name is required"
            error = true

        }

        if (lastName.isBlank()) {
            binding.tilLastName.error = "first name is required"
            error = true

        }

        if (number.isBlank()) {
            binding.tilPhoneNumber.error = "phone number  is required"
            error = true

        }

        if (email.isBlank()) {
            binding.tilEmail.error = " email is required"
            error = true


        }

        if (!error) {
            val intent = Intent(this, addedUser::class.java)
            startActivity(intent)
            Toast.makeText(this, "$firstName $lastName $email", Toast.LENGTH_LONG).show()
            finish()
        }
    }

        fun clearErrors() {
            binding.tilFirstName.error = null
            binding.tilLastName.error = null
            binding.tilPhoneNumber.error = null
            binding.tilEmail.error = null
        }
    }






