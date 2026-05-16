package com.example.nammamela

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.nammamela.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupUI()
    }

    private fun setupUI() {
        // Load simulated poster using Glide
        // Using a placeholder image URL for drama
        val posterUrl = "https://images.unsplash.com/photo-1503095396549-807759c4bc0e?q=80&w=2070&auto=format&fit=crop"
        Glide.with(this)
            .load(posterUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.ivPoster)

        binding.btnBookSeats.setOnClickListener {
            startActivity(Intent(this, BookingActivity::class.java))
        }

        binding.btnSend.setOnClickListener {
            val comment = binding.etApplause.text.toString()
            if (comment.isNotBlank()) {
                Toast.makeText(this, "Applause Sent: $comment", Toast.LENGTH_SHORT).show()
                binding.etApplause.text?.clear()
            }
        }
    }
}
