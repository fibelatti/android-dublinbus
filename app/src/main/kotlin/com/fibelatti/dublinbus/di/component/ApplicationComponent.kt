package com.fibelatti.dublinbus.di.component

import android.content.Context
import android.content.SharedPreferences
import com.fibelatti.dublinbus.AndroidApplication
import com.fibelatti.dublinbus.di.module.*
import com.fibelatti.dublinbus.presentation.activities.MainActivity
import com.fibelatti.dublinbus.presentation.activities.SearchActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        RepositoryModule::class,
        RetrofitModule::class,
        PresenterModule::class,
        AdapterModule::class))
interface ApplicationComponent {
    fun app(): AndroidApplication

    fun context(): Context

    fun preferences(): SharedPreferences

    fun inject(mainActivity: MainActivity)

    fun inject(searchActivity: SearchActivity)
}
