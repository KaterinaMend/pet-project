package com.rickandmorty.rickandmortyapp.app

import android.app.Application
import com.rickandmorty.rickandmortyapp.app.di.appModule
import com.rickandmorty.rickandmortyapp.app.di.dataModule
import com.rickandmorty.rickandmortyapp.app.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class RickAndMortyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RickAndMortyApplication)
            modules(
                appModule,
                dataModule,
                domainModule,
            )
        }
    }
}