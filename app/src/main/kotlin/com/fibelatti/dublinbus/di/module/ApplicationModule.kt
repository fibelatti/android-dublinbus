package com.fibelatti.dublinbus.di.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.fibelatti.dublinbus.AndroidApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(var app: AndroidApplication) {

    @Provides
    @Singleton
    fun provideApp(): AndroidApplication = app

    @Provides
    @Singleton
    fun provideContext(): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(app)
}
