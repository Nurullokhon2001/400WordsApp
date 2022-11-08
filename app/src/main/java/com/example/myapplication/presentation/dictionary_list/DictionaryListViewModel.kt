package com.example.myapplication.presentation.dictionary_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.Sounds
import com.example.myapplication.domain.model.VocabularyModel
import com.example.myapplication.domain.use_case.GetSoundUseCase
import com.example.myapplication.domain.use_case.GetVocabularyUseCase
import com.example.myapplication.domain.use_case.SearchVocabularyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DictionaryListViewModel @Inject constructor(
    private val getVocabularyUseCase: GetVocabularyUseCase,
    private val getSoundUseCase: GetSoundUseCase,
    private val searchVocabularyUseCase: SearchVocabularyUseCase,
) : ViewModel() {

    fun getVocabulary(): LiveData<List<VocabularyModel>> {
        val list = MutableLiveData<List<VocabularyModel>>()
        viewModelScope.launch {
            list.value = getVocabularyUseCase.invoke()
        }
        return list
    }

    private val _sound = MutableLiveData<Sounds>()
    val sound: LiveData<Sounds> get() = _sound


    fun getSound(id: Int) {
        viewModelScope.launch {
            _sound.value = getSoundUseCase.invoke(id)
        }
    }

    fun searchVocabulary(words: String): LiveData<List<VocabularyModel>> {
        val list = MutableLiveData<List<VocabularyModel>>()
        viewModelScope.launch {
            list.value = searchVocabularyUseCase.invoke(words)
        }
        return list
    }
}