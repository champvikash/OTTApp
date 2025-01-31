package com.example.ottapp.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.ottapp.data.repository.AnimeListRepository
import com.example.ottapp.di.ActivityContext
import com.example.ottapp.ui.AnimeListAdapter
import com.example.ottapp.ui.base.AnimeListViewModel
import com.example.ottapp.ui.base.ViewModelProviderFactory
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideTopHeadlineViewModel(animeListRepo: AnimeListRepository): AnimeListViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(AnimeListViewModel::class) {
                AnimeListViewModel(animeListRepo)
            })[AnimeListViewModel::class.java]
    }

    @Provides
    fun provideAnimeListAdapter() = AnimeListAdapter(
        ArrayList()
    )

}