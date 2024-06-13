package com.example.fragmentssortowanie

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.fragmentssortowanie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id, StartFragment())
                .commit()
        }


    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(binding.fragmentContainer.id, fragment)
            setReorderingAllowed(true)
            addToBackStack(null)
        }


    }

    fun bubbleSort(view: View){
        replaceFragment(BubbleSort())
    }

    fun insertionSort(view: View){
        replaceFragment(InsertionSort())
    }
}