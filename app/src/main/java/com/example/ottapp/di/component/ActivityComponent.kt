package com.example.ottapp.di.component

import com.example.ottapp.di.ActivityScope
import com.example.ottapp.di.module.ActivityModule
import com.example.ottapp.ui.screens.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}