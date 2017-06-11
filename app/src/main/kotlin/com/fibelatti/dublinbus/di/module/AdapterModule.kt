package com.fibelatti.dublinbus.di.module

import com.fibelatti.dublinbus.presentation.adapters.SearchByStopNumberAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

    @Provides
    fun provideSearchByStopNumberAdapter(): SearchByStopNumberAdapter {
        return SearchByStopNumberAdapter()
    }
}
