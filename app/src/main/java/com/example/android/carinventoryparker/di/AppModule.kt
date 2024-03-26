package com.example.android.carinventoryparker.di

import android.content.Context
import androidx.room.Room
import com.example.android.carinventoryparker.model.db.CAR_DATABASE
import com.example.android.carinventoryparker.model.db.CarDatabase
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
}
