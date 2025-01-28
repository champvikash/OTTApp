package com.example.ottapp.di.component

import android.content.Context
import com.example.ottapp.MVVMApplication
import com.example.ottapp.data.api.NetworkService
import com.example.ottapp.data.repository.AnimeListRepository
import com.example.ottapp.di.ApplicationContext
import com.example.ottapp.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {


    fun inject(applicationModule: MVVMApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getAnimeList(): AnimeListRepository
}