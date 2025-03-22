package com.example.tgs_2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tgs_2.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inisialisasi ViewBinding sebelum setContentView
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Terapkan WindowInsets untuk mengatur padding agar sesuai dengan sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Event klik untuk tombol "Daftar"
        binding.btnRegister.setOnClickListener {
            val nama = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val konfirmasiPassword = binding.etConfirmPassword.text.toString().trim()

            if (nama.isEmpty()) {
                binding.etName.error = "Nama tidak boleh kosong"
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                binding.etEmail.error = "Email tidak boleh kosong"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.etPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }

            if (konfirmasiPassword.isEmpty()) {
                binding.etConfirmPassword.error = "Konfirmasi password tidak boleh kosong"
                return@setOnClickListener
            }

            if (password != konfirmasiPassword) {
                binding.etConfirmPassword.error = "Password tidak cocok"
                return@setOnClickListener
            }

            // Jika semua input sudah diisi dan password cocok
            Toast.makeText(this, "Daftar Berhasil", Toast.LENGTH_SHORT).show()

            // Pindah ke halaman Login
            val intentLogin = Intent(this, LoginActivity::class.java)
            startActivity(intentLogin)
            finish() // Tutup RegisterActivity agar tidak bisa kembali ke sini
        }

        // Event klik untuk "Sudah punya akun? Login"
        binding.txtRegister.setOnClickListener {
            val intentLogin = Intent(this, LoginActivity::class.java)
            startActivity(intentLogin)
            finish()
        }
    }
}
