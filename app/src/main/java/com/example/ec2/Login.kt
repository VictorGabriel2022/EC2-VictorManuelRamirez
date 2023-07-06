package com.example.ec2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class Login : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        btnLogin.isEnabled = false

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (isValidCredentials(username, password)) {

                loginSuccessful()
            } else {

                Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_SHORT).show()
            }
        }


        etUsername.addTextChangedListener { onTextChanged() }
        etPassword.addTextChangedListener { onTextChanged() }
    }

    private fun isValidCredentials(username: String, password: String): Boolean {

        return username == "ejemplo@idat.edu.pe" && password == "123456"
    }

    private fun loginSuccessful() {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun onTextChanged() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()
        btnLogin.isEnabled = isValidCredentials(username, password)
    }
}


