package com.fibelatti.dublinbus.data.repository

import com.fibelatti.dublinbus.data.models.StopInformation
import io.reactivex.Observable

interface DublinBusRepository {
    fun getByStopId(stopId: Int): Observable<StopInformation>
}