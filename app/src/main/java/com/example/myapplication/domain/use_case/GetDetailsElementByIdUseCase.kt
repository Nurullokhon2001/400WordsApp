package com.example.myapplication.domain.use_case

import com.example.myapplication.domain.model.ElementDetailsModel
import com.example.myapplication.domain.repository.Repository
import javax.inject.Inject

class GetDetailsElementByIdUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(id: Int): ElementDetailsModel {
        return repository.getDetailsElementById(id)
    }
}