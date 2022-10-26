package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.RepositoryImpl
import com.example.myapplication.data.data.Elements
import com.example.myapplication.data.room.AppDatabase
import com.example.myapplication.data.room.DbDao
import com.example.myapplication.domain.questions_use_case.GetRusTajQuestionsUseCase
import com.example.myapplication.domain.questions_use_case.GetTajRuQuestionsUseCase
import com.example.myapplication.domain.repository.Repository
import com.example.myapplication.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    fun provideRepo(elements : Elements,dao: DbDao): Repository = RepositoryImpl(elements,dao)

    @Provides
    fun provideGetTableListUseCase(repository: Repository) = GetVocabularyUseCase(repository)

    @Provides
    fun provideGetDetailsElementByIdUseCase(repository: Repository) = GetDetailsElementByIdUseCase(repository)

    @Provides
    fun provideGetElementsByIdUseCase(repository: Repository) = GetElementsByIdUseCase(repository)

    @Provides
    fun provideGetFormulasUseCase(repository: Repository) = GetFormulasUseCase(repository)

    @Provides
    fun provideGetTajRuQuestionsUseCase(repository: Repository) = GetTajRuQuestionsUseCase(repository)

    @Provides
    fun provideGetRusTajQuestionsUseCase(repository: Repository) = GetRusTajQuestionsUseCase(repository)

    @Provides
    fun provideElements() = Elements


    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "words400"
    ).createFromAsset("words400.sqlite").build() // The reason we can construct a database for the repo

    @Provides
    fun provideYourDao(db: AppDatabase) = db.getDao()
}