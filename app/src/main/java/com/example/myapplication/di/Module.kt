package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.RepositoryImpl
import com.example.myapplication.data.room.AppDatabase
import com.example.myapplication.data.room.DbDao
import com.example.myapplication.domain.quiz_use_case.QuizUseCase
import com.example.myapplication.domain.repository.Repository
import com.example.myapplication.domain.test_use_case.GetRusTajQuestionsUseCase
import com.example.myapplication.domain.test_use_case.GetTajRuQuestionsUseCase
import com.example.myapplication.domain.use_case.GetSoundUseCase
import com.example.myapplication.domain.use_case.GetVocabularyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {


    @Provides
    fun provideGetTableListUseCase(repository: Repository) = GetVocabularyUseCase(repository)


    @Provides
    fun provideGetTajRuQuestionsUseCase(repository: Repository) =
        GetTajRuQuestionsUseCase(repository)

    @Provides
    fun provideGetRusTajQuestionsUseCase(repository: Repository) =
        GetRusTajQuestionsUseCase(repository)

    @Provides
    fun provideGetSoundUseCase(repository: Repository) = GetSoundUseCase(repository)

    @Provides
    fun provideQuizTjEngUseCase(repository: Repository) = QuizUseCase(repository)

    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "words400"
    ).createFromAsset("words400.sqlite").fallbackToDestructiveMigration().build()

    @Provides
    fun provideYourDao(db: AppDatabase) = db.getDao()

    @Provides
    @Singleton
    fun provideRepository(dao: DbDao): Repository = RepositoryImpl(dao)
}