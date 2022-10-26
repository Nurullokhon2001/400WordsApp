package com.example.myapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemInDetailsDescBinding
import com.example.myapplication.domain.model.FormulasModel
import com.example.myapplication.presentation.adapter.FormulasAdapter.ViewHolder

class FormulasAdapter : ListAdapter<FormulasModel, ViewHolder>(ItemCallback) {
    inner class ViewHolder(private val binding: ItemInDetailsDescBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(model: FormulasModel) {
            with(binding) {
                elementLabel.text = model.name
                elementDesc.text = model.formula
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemInDetailsDescBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(getItem(position))
    }


    object ItemCallback : DiffUtil.ItemCallback<FormulasModel>() {
        override fun areItemsTheSame(oldItem: FormulasModel, newItem: FormulasModel): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: FormulasModel, newItem: FormulasModel): Boolean {
            return oldItem == newItem
        }
    }
}