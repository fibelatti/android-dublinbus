package com.fibelatti.dublinbus.base

interface BasePresenter<in V : BaseView> {
    fun attachView(view: V)

    fun detachView()
}
