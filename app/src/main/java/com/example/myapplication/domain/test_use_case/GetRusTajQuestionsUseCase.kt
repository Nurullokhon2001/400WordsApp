package com.example.myapplication.domain.test_use_case

import android.util.Log
import com.example.myapplication.domain.model.Question
import com.example.myapplication.domain.model.Temporal
import com.example.myapplication.domain.repository.Repository
import javax.inject.Inject

class GetRusTajQuestionsUseCase @Inject constructor(
    private val repository: Repository
) {
    var questions = mutableListOf<Question>()
    suspend operator fun invoke(): List<Question> {
        return createQuestions()
    }

    private suspend fun createQuestions(): List<Question> {
        val temporalQuestions = mutableListOf<Temporal>()

        for (i in 0..14) {
            val vocabulary = repository.getVocabulary().shuffled()
            for (index in 0..2) {
                    temporalQuestions.add(
                        Temporal(
                            vocabulary[index].rus!!,
                            vocabulary[index].tjk,
                        )
                    )
            }
            val a = temporalQuestions[0].from
            temporalQuestions.shuffle()
            val index = temporalQuestions.indexOfFirst {
                it.from == a
            }

            val index2 = vocabulary.indexOfFirst {
                temporalQuestions[index].to == it.tjk
            }

            when (index) {
                0 -> {
                    questions.add(
                        Question(
                            i,
                            question = a,
                            vocabulary[index2].tjk,
                            vocabulary[(1..400).random()].tjk,
                            vocabulary[(1..400).random()].tjk,
                            correctOption = index+1
                        )
                    )
                }
                1 -> {
                    questions.add(
                        Question(
                            i,
                            question = a,
                            vocabulary[(1..400).random()].tjk,
                            vocabulary[index2].tjk,
                            vocabulary[(1..400).random()].tjk,
                            correctOption = index+1
                        )
                    )
                }
                else -> {
                    questions.add(
                        Question(
                            i,
                            question = a,
                            vocabulary[(1..400).random()].tjk,
                            vocabulary[(1..400).random()].tjk,
                            vocabulary[index2].tjk,
                            correctOption = index+1
                        )
                    )
                }
            }
            temporalQuestions.clear()
        }
        for (item in questions){
            Log.e("invoke", item.toString(), )
        }
        return questions
    }
}