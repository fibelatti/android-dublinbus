package com.fibelatti.dublinbus.presentation.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.WindowManager
import com.fibelatti.dublinbus.AndroidApplication
import com.fibelatti.dublinbus.R
import com.fibelatti.dublinbus.base.BaseActivity
import com.fibelatti.dublinbus.base.hideKeyboard
import com.fibelatti.dublinbus.base.toast
import com.fibelatti.dublinbus.data.models.StopInformation
import com.fibelatti.dublinbus.helpers.Utils
import com.fibelatti.dublinbus.helpers.ifNotNull
import com.fibelatti.dublinbus.presentation.adapters.SearchByStopNumberAdapter
import com.fibelatti.dublinbus.presentation.presenters.SearchByStopPresenter
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.toolbar_default.*
import javax.inject.Inject

fun Context.SearchActivityIntent() = Intent(this, SearchActivity::class.java)

class SearchActivity : BaseActivity(), SearchByStopPresenter.View {

    @Inject
    lateinit var presenter: SearchByStopPresenter
    @Inject
    lateinit var adapter: SearchByStopNumberAdapter
    var stopId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        AndroidApplication.appComponent.inject(this)

        presenter.attachView(this)

        setUpLayout()
        setUpRecyclerView()
        setUpListeners()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    private fun setUpLayout() {
        setSupportActionBar(toolbar)
        setTitle(R.string.search_activity_title)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setUpRecyclerView() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.adapter = adapter
    }

    private fun setUpListeners() {
        button_search.setOnClickListener { validateQueryAndSearch() }
        button_refresh.setOnClickListener { validateQueryAndSearch() }
    }

    private fun validateQueryAndSearch() {
        if (validateQuery(input_stop_id.text.toString())) {
            hideKeyboard()
            showProgress()
            stopId = Integer.valueOf(input_stop_id.text.toString())
            presenter.performSearch(stopId)
        }
    }

    private fun validateQuery(query: String): Boolean {
        if (query.isNullOrEmpty()) {
            input_layout_stop_id.error = getString(R.string.search_activity_error_stop_number)
            requestFocus(input_layout_stop_id)
            return false
        } else {
            try {
                query.toDouble()
                input_layout_stop_id.error = null
                input_layout_stop_id.isErrorEnabled = false
                return true
            } catch(e: NumberFormatException) {
                input_layout_stop_id.error = getString(R.string.search_activity_error_stop_number)
                requestFocus(input_layout_stop_id)
                return false
            }
        }
    }

    private fun requestFocus(view: View) {
        if (view.requestFocus()) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }
    }

    private fun showResults() {
        recycler_view.visibility = View.VISIBLE
        placeholder.visibility = View.GONE
    }

    private fun showPlaceholder() {
        recycler_view.visibility = View.GONE
        placeholder.visibility = View.VISIBLE
    }

    override fun resultFetched(stopInformation: StopInformation) {
        Utils.ifNotNull(stopInformation.errorcode, stopInformation.results) {
            errorCode, results ->
            hideProgress()
            if (errorCode == "0" && results.isNotEmpty()) {
                showResults()

                text_view_refresh_time.text = getString(R.string.search_activity_text_refresh_time, stopInformation.timestamp)

                adapter.clearList()
                adapter.addManyToList(stopInformation.results!!)
            } else {
                showPlaceholder()
            }
        }
    }

    override fun handleError(errorMessage: String) {
        toast(errorMessage)
    }
}
