package com.example.myapplication.domain.use_case

import com.example.myapplication.domain.model.Sounds
import com.example.myapplication.domain.repository.Repository
import javax.inject.Inject

class GetSoundUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(id: Int): Sounds {
        return repository.getSound(id)
    }
}