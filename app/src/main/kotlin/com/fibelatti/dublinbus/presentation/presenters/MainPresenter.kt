package com.fibelatti.dublinbus.presentation.presenters

import com.fibelatti.dublinbus.base.BasePresenter
import com.fibelatti.dublinbus.base.BaseView

interface MainPresenter : BasePresenter<MainPresenter.View> {
    fun onSearchByStop()

    fun onFavourites()

    interface View : BaseView {
        fun goToSearchByStopNumber()

        fun goToFavorites()
    }
}