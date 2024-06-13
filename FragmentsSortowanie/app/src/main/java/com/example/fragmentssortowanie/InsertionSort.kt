package com.example.fragmentssortowanie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.fragmentssortowanie.databinding.FragmentInsertionSortBinding

class InsertionSort : Fragment() {
    private var _binding: FragmentInsertionSortBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInsertionSortBinding.inflate(inflater, container, false)
        val view = binding.root

        sharedViewModel.inputText.observe(viewLifecycleOwner) { inputText ->
            val sortedArray = Sorting.insertionSort(inputText)
            binding.outputInsertionSort.setText(sortedArray.joinToString(","))
        }

        return view
    }


}