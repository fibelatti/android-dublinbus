package com.fibelatti.dublinbus.presentation.presenters

import com.fibelatti.dublinbus.base.BasePresenter
import com.fibelatti.dublinbus.base.BaseView
import com.fibelatti.dublinbus.data.models.StopInformation

interface SearchByStopPresenter : BasePresenter<SearchByStopPresenter.View> {
    fun performSearch(stopId: Int)

    interface View : BaseView {
        fun resultFetched(stopInformation: StopInformation)
    }
}