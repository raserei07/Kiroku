package com.example.kiroku.di

import com.example.kiroku.ui.navigation.AppNavigator
import com.example.kiroku.ui.navigation.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Binds
    @Singleton
    abstract fun bindAppNavigator(impl: AppNavigatorImpl): AppNavigator
}
