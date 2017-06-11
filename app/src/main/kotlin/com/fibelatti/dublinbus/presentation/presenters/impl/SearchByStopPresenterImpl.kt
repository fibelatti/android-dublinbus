package com.fibelatti.dublinbus.presentation.presenters.impl

import com.fibelatti.dublinbus.data.repository.DublinBusRepository
import com.fibelatti.dublinbus.presentation.presenters.SearchByStopPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchByStopPresenterImpl(private val dublinBusRepository: DublinBusRepository) : SearchByStopPresenter {
    var view: SearchByStopPresenter.View? = null

    override fun attachView(view: SearchByStopPresenter.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun performSearch(stopId: Int) {
        dublinBusRepository.getByStopId(stopId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { stopInformation -> view?.resultFetched(stopInformation) },
                        { e -> view?.handleError(e.message!!) }
                )
    }
}