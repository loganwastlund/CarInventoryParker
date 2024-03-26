package com.example.android.carinventoryparker.di

import android.content.Context
import androidx.room.Room
import com.example.android.carinventoryparker.model.db.CAR_DATABASE
import com.example.android.carinventoryparker.model.db.CarDatabase
import com.example.android.carinventoryparker.model.repository.CarRepository
import com.example.android.carinventoryparker.model.repository.CarRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideCarDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context.applicationContext,
        CarDatabase::class.java,
        CAR_DATABASE
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideRepository(database: CarDatabase): CarRepository = CarRepositoryImpl(database)
}
