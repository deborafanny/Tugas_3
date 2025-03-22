package com.example.tgs_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class BerandaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

        // Inisialisasi EditText dan Button
        val txtDesc = findViewById<EditText>(R.id.txtDesc)
        val btnShare = findViewById<Button>(R.id.btnExplore)
        val btnLogout = findViewById<ImageView>(R.id.btnLogout)

        // Ketika tombol Share ditekan
        btnShare.setOnClickListener {
            val textToShare = txtDesc.text.toString().trim() // Ambil teks dari EditText
            if (textToShare.isNotEmpty()) {
                shareText(textToShare) // Bagikan teks jika tidak kosong
            } else {
                txtDesc.error = "Tulis sesuatu untuk dibagikan!" // Tampilkan error jika kosong
            }
        }

        // Ketika tombol Logout ditekan
        btnLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    // Fungsi untuk berbagi teks ke WhatsApp, Facebook, Instagram, dll.
    private fun shareText(text: String) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
        }
        startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
    }
}
