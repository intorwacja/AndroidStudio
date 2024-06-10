package com.example.intentssortowanie

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentssortowanie.databinding.ActivityBubbleSortBinding

class BubbleSort : AppCompatActivity() {
    private lateinit var binding: ActivityBubbleSortBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBubbleSortBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text = intent.getStringExtra("extra_text").toString()
        val sorted = Sorting.bubbleSort(text)
        binding.outputArray.setText(sorted.joinToString(","))
    }
}