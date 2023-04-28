package com.thenexprojects.hiltexampleapplication.di

import android.content.Context
import com.thenexprojects.hiltexampleapplication.di.qualifiers.EngineVolume
import com.thenexprojects.hiltexampleapplication.example.Engine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(FragmentComponent::class)
object CarModule {
    @Provides
    fun provideString(@ApplicationContext context: Context): String{
        return "Model"
    }

    @Provides
    fun provideEngine(@EngineVolume volume: Double): Engine{
        return Engine(volume)
    }

    @Provides
    @EngineVolume
    fun provideVolume(): Double{
        return 2.2
    }
}