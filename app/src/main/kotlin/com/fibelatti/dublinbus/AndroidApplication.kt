package com.fibelatti.dublinbus

import android.app.Application
import com.fibelatti.dublinbus.di.component.ApplicationComponent
import com.fibelatti.dublinbus.di.component.DaggerApplicationComponent
import com.fibelatti.dublinbus.di.module.ApplicationModule

class AndroidApplication : Application() {
    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}
