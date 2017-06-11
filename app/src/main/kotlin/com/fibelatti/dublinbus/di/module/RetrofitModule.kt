package com.fibelatti.dublinbus.di.module

import com.fibelatti.dublinbus.data.DublinBusService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideDublinBusService(): DublinBusService = DublinBusService.create()
}