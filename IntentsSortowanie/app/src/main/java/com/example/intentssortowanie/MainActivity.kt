package com.example.intentssortowanie

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentssortowanie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bubbleButton.setOnClickListener {
            val text = binding.inputString.text.toString()
            val intent = Intent(this, BubbleSort::class.java).apply {
                putExtra("extra_text", text)
            }
            startActivity(intent)
        }

        binding.insertionButton.setOnClickListener {
            val text = binding.inputString.text.toString()
            val intent = Intent(this, InsertionSort::class.java).apply {
                putExtra("extra_text", text)
            }
            startActivity(intent)
        }
    }
}
