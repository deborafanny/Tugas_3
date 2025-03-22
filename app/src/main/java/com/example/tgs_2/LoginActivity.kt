package com.example.tgs_2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tgs_2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inisialisasi ViewBinding sebelum setContentView
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Terapkan WindowInsets untuk mengatur padding agar sesuai dengan sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Event click untuk tombol login
        binding.btnLogin.setOnClickListener {
            val intentBerandaActivity = Intent(this, BerandaActivity::class.java)
            startActivity(intentBerandaActivity)
        }

        // Event click untuk "Lupa Password"
        binding.tvlupa.setOnClickListener {
            val intentForgotPassword = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intentForgotPassword)
        }

        // Event click untuk "Register"
        binding.tvRegister.setOnClickListener {
            val intentRegister = Intent(this, RegisterActivity::class.java)
            startActivity(intentRegister)
        }
    }
}
