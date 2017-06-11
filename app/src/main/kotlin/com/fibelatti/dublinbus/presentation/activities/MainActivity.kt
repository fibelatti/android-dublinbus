package com.fibelatti.dublinbus.presentation.activities

import android.os.Bundle
import com.fibelatti.dublinbus.AndroidApplication
import com.fibelatti.dublinbus.R
import com.fibelatti.dublinbus.base.BaseActivity
import com.fibelatti.dublinbus.base.toast
import com.fibelatti.dublinbus.presentation.presenters.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_default.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainPresenter.View {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidApplication.appComponent.inject(this)

        presenter.attachView(this)

        setUpLayout()
        setUpListeners()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    private fun setUpLayout() {
        setSupportActionBar(toolbar)
        setTitle(R.string.main_activity_title)
    }

    private fun setUpListeners() {
        card_view_by_stop.setOnClickListener { presenter.onSearchByStop() }
        card_view_favourites.setOnClickListener { presenter.onFavourites() }
    }

    override fun goToSearchByStopNumber() = startActivity(SearchActivityIntent())

    override fun goToFavorites() {
        handleError("Not Implemented Yet.")
    }

    override fun handleError(errorMessage: String) {
        toast(errorMessage)
    }
}
