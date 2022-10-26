package com.example.myapplication.domain.model

data class Question(
    val id: Int,
    val question: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val correctOption: Int
){
    override fun toString(): String {
        return "$question, $optionOne ,$optionTwo, $optionThree,  $correctOption"
    }
}

