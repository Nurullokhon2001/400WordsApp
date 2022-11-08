package com.example.myapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemTableListBinding
import com.example.myapplication.domain.model.VocabularyModel
import com.example.myapplication.presentation.adapter.DictionaryListAdapter.*

class DictionaryListAdapter(
   private val tableListClickListener: (Int?) -> Unit
) : ListAdapter<VocabularyModel, ViewHolder>(ItemCallback) {
    inner class ViewHolder(private val binding: ItemTableListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(model: VocabularyModel) {
            with(binding) {
                tjk.text = model.tjk
                ru.text = model.rus
                eng.text = model.eng
                binding.root.setOnClickListener {
                    tableListClickListener.invoke(model.id)
                }
            }
        }

//        private fun setColors(color: Int): Int {
//            return binding.tableId.context.getColor(color)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemTableListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(getItem(position))
    }


    object ItemCallback : DiffUtil.ItemCallback<VocabularyModel>() {
        override fun areItemsTheSame(oldItem: VocabularyModel, newItem: VocabularyModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: VocabularyModel, newItem: VocabularyModel): Boolean {
            return oldItem == newItem
        }
    }
}