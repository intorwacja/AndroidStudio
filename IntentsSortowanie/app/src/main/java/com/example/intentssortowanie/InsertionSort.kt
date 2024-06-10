package com.example.intentssortowanie

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentssortowanie.databinding.ActivityInsertionSortBinding

class InsertionSort : AppCompatActivity() {
    private lateinit var binding: ActivityInsertionSortBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertionSortBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text = intent.getStringExtra("extra_text").toString()
        val sorted = Sorting.insertionSort(text)
        binding.outputArrayInsertion.setText(sorted.joinToString(","))

    }
}