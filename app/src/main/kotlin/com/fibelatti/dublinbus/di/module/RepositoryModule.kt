package com.fibelatti.dublinbus.di.module

import com.fibelatti.dublinbus.data.DublinBusService
import com.fibelatti.dublinbus.data.repository.DublinBusRepository
import com.fibelatti.dublinbus.data.repository.impl.DublinBusRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideDublinBusRepository(dublinBusService: DublinBusService): DublinBusRepository {
        return DublinBusRepositoryImpl(dublinBusService)
    }
}
