package com.fibelatti.dublinbus.di.module

import com.fibelatti.dublinbus.data.repository.DublinBusRepository
import com.fibelatti.dublinbus.presentation.presenters.MainPresenter
import com.fibelatti.dublinbus.presentation.presenters.SearchByStopPresenter
import com.fibelatti.dublinbus.presentation.presenters.impl.MainPresenterImpl
import com.fibelatti.dublinbus.presentation.presenters.impl.SearchByStopPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideMainPresenter(): MainPresenter {
        return MainPresenterImpl()
    }

    @Provides
    @Singleton
    fun provideSearchByStopPresenter(dublinBusRepository: DublinBusRepository): SearchByStopPresenter {
        return SearchByStopPresenterImpl(dublinBusRepository)
    }
}
