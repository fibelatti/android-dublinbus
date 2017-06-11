package com.fibelatti.dublinbus.presentation.presenters.impl

import com.fibelatti.dublinbus.presentation.presenters.MainPresenter

class MainPresenterImpl : MainPresenter {
    var view: MainPresenter.View? = null

    override fun attachView(view: MainPresenter.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun onSearchByStop() = view!!.goToSearchByStopNumber()

    override fun onFavourites() = view!!.goToFavorites()
}