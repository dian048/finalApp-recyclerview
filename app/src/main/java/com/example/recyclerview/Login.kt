package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recyclerview.databinding.LoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()

            if (username == "Dian" && password == "12345") {
                Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@Login, MainActivity::class.java)
                startActivity(intent)
                finish() // Optional: Sebaiknya tambahkan finish() agar LoginActivity ditutup setelah berhasil login
            } else {
                Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
