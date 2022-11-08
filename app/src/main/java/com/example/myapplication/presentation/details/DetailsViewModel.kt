package com.example.myapplication.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.model.ElementDetailsModel
import com.example.myapplication.domain.model.VocabularyModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
) : ViewModel() {

    fun getElementsById(id: Int): LiveData<VocabularyModel> {
        val element = MutableLiveData<VocabularyModel>()
            //  element.value = getElementsByIdUseCase.invoke(id)
        return element
    }

    fun getDetailsElementById(id: Int): LiveData<ElementDetailsModel> {
        val element = MutableLiveData<ElementDetailsModel>()
    //    element.value = getDetailsElementByIdUseCase.invoke(id)
        return element
    }
}