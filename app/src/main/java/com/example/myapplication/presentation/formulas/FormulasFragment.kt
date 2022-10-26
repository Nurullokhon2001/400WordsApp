package com.example.myapplication.presentation.formulas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.myapplication.databinding.FragmentFormulasBinding
import com.example.myapplication.presentation.adapter.FormulasAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormulasFragment : Fragment() {

    private var _binding: FragmentFormulasBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { FormulasAdapter() }
    private val viewModel by viewModels<FormulasViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFormulasBinding.inflate(layoutInflater, container, false)

        viewModel.getTableList().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.list.adapter = adapter
        return binding.root
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}