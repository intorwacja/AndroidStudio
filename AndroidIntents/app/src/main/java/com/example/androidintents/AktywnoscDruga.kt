package com.example.androidintents

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidintents.databinding.AktywnoscDrugaBinding

class AktywnoscDruga : AppCompatActivity() {
    private lateinit var binding: AktywnoscDrugaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = AktywnoscDrugaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dane_in = intent.extras ?:return
        val tekst = dane_in.getString("tekst")
        binding.tekst2a.text = tekst
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right,
                systemBars.bottom)
            insets
        }
    }

    fun odeslijTekst(view: View) {
        finish()
    }
    override fun finish() {
        val data = Intent()
        val tekstZwrotnyg = binding.tekst2b.text.toString()
        data.putExtra("daneZwrotne", tekstZwrotnyg)
        setResult(RESULT_OK, data)
        super.finish()
    }

}