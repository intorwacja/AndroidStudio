package com.example.fragmentssortowanie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import com.example.fragmentssortowanie.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.bubblesortButton.setOnClickListener {
            val inputText = binding.inputText.text.toString()
            sharedViewModel.setInputText(inputText)
            replaceFragment(BubbleSort())
        }

        binding.insertionsortButton.setOnClickListener {
            val inputText = binding.inputText.text.toString()
            sharedViewModel.setInputText(inputText)
            replaceFragment(InsertionSort())
        }



        return binding.root
    }

    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager.commit {
            replace(R.id.fragment_container, fragment)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}