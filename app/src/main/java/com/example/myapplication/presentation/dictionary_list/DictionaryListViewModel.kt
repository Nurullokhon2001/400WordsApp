package com.example.myapplication.presentation.dictionary_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.room.DbDao
import com.example.myapplication.domain.model.VocabularyListModel
import com.example.myapplication.domain.use_case.GetVocabularyUseCase
import com.example.myapplication.domain.use_case.SearchVocabularyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DictionaryListViewModel @Inject constructor(
    private val getVocabularyUseCase: GetVocabularyUseCase,
    private val searchVocabularyUseCase: SearchVocabularyUseCase,
) : ViewModel() {

    fun getVocabulary(): LiveData<List<VocabularyListModel>> {
        val list = MutableLiveData<List<VocabularyListModel>>()
            viewModelScope.launch {
                list.value = getVocabularyUseCase.invoke()
            }
        return list
    }


    fun searchVocabulary(words : String): LiveData<List<VocabularyListModel>> {
        val list = MutableLiveData<List<VocabularyListModel>>()
        viewModelScope.launch {
            list.value = searchVocabularyUseCase.invoke(words)
        }
        return list
    }
}