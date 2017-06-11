package com.fibelatti.dublinbus.base

import android.view.View

interface BaseView {
    fun showProgress()

    fun hideProgress()

    fun getContentView() : View

    fun handleError(errorMessage: String)
}
