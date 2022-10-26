package com.example.myapplication.presentation.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentDetailsBinding
import com.example.myapplication.domain.model.ElementDetailsModel
import com.example.myapplication.domain.model.VocabularyListModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val args: DetailsFragmentArgs by navArgs()

    private val viewModel by viewModels<DetailsViewModel>()

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)

        viewModel.getElementsById(args.id).observe(viewLifecycleOwner) {
            setElementData(it)
        }
        viewModel.getDetailsElementById(args.id).observe(viewLifecycleOwner) {
            setDetailsElement(it)
        }
        return binding.root
    }

    private fun setElementData(element: VocabularyListModel) = with(binding) {
        tableName.text = element.tjk
        tableId.text = element.id.toString()
        tableWeight.text = element.rus
        alphabet.text = element.eng
//        when (element.category) {
//            1 -> alphabet.setTextColor(setColors(R.color.s_elements))
//            2 -> alphabet.setTextColor(setColors(R.color.p_elements))
//            3 -> alphabet.setTextColor(setColors(R.color.d_elements))
//            4 -> alphabet.setTextColor(setColors(R.color.f_elements))
//        }
    }

    private fun setDetailsElement(elementDetailsModel: ElementDetailsModel) = with(binding) {
        first.elementLabel.text = "Электроманфии нисбӣ (мувофиқи Полинг):"
        second.elementLabel.text = "Ҳарорати обшавӣ:"
        third.elementLabel.text = "Ҳарорати ҷӯшиш:"
        fourth.elementLabel.text = "Қобилияти гармидиҳӣ:"
        fives.elementLabel.text = "Зичӣ:"
        six.elementLabel.text = "Ихтироъ:"

        first.elementDesc.text = elementDetailsModel.first
        second.elementDesc.text = elementDetailsModel.second
        third.elementDesc.text = elementDetailsModel.third
        fourth.elementDesc.text = elementDetailsModel.fourth
        fives.elementDesc.text = elementDetailsModel.fives
        six.elementDesc.text = elementDetailsModel.six


    }

//    private fun setColors(color: Int): Int {
//        return binding.tableId.context.getColor(color)
//    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}