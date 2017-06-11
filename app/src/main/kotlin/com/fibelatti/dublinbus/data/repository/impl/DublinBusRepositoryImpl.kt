package com.fibelatti.dublinbus.data.repository.impl

import com.fibelatti.dublinbus.data.DublinBusService
import com.fibelatti.dublinbus.data.models.StopInformation
import com.fibelatti.dublinbus.data.repository.DublinBusRepository
import io.reactivex.Observable

class DublinBusRepositoryImpl(val dublinBusService: DublinBusService) : DublinBusRepository{
    override fun getByStopId(stopId: Int): Observable<StopInformation> {
        return dublinBusService.getByStopId(stopId)
    }
}