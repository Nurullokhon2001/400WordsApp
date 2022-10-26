package com.example.myapplication.domain.use_case

import com.example.myapplication.domain.model.FormulasModel
import com.example.myapplication.domain.repository.Repository
import javax.inject.Inject

class GetFormulasUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(): List<FormulasModel> {
        return repository.getFormulas()
    }
}