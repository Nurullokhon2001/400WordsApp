package com.example.myapplication.presentation.formulas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.model.FormulasModel
import com.example.myapplication.domain.use_case.GetFormulasUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FormulasViewModel @Inject constructor(
    private val getFormulasUseCase: GetFormulasUseCase
):ViewModel() {

    fun getTableList(): LiveData<List<FormulasModel>> {
        val list = MutableLiveData<List<FormulasModel>>()
        list.value = getFormulasUseCase.invoke()
        return list
    }
}