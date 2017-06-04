package com.fibelatti.dublinbus

import android.app.Application

class AndroidApplication : Application() {
    val TAG = AndroidApplication::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}
