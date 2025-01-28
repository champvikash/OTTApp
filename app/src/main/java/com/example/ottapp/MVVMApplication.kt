package com.example.ottapp

import android.app.Application
import com.example.ottapp.di.component.ApplicationComponent
import com.example.ottapp.di.component.DaggerApplicationComponent
import com.example.ottapp.di.module.ApplicationModule

class MVVMApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}