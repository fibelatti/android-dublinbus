package com.fibelatti.dublinbus.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StopInformationResult {
    @SerializedName("arrivaldatetime")
    @Expose
    var arrivaldatetime: String? = null
    @SerializedName("duetime")
    @Expose
    var duetime: String? = null
    @SerializedName("departuredatetime")
    @Expose
    var departuredatetime: String? = null
    @SerializedName("departureduetime")
    @Expose
    var departureduetime: String? = null
    @SerializedName("scheduledarrivaldatetime")
    @Expose
    var scheduledarrivaldatetime: String? = null
    @SerializedName("scheduleddeparturedatetime")
    @Expose
    var scheduleddeparturedatetime: String? = null
    @SerializedName("destination")
    @Expose
    var destination: String? = null
    @SerializedName("destinationlocalized")
    @Expose
    var destinationlocalized: String? = null
    @SerializedName("origin")
    @Expose
    var origin: String? = null
    @SerializedName("originlocalized")
    @Expose
    var originlocalized: String? = null
    @SerializedName("direction")
    @Expose
    var direction: String? = null
    @SerializedName("operator")
    @Expose
    var operator: String? = null
    @SerializedName("additionalinformation")
    @Expose
    var additionalinformation: String? = null
    @SerializedName("lowfloorstatus")
    @Expose
    var lowfloorstatus: String? = null
    @SerializedName("route")
    @Expose
    var route: String? = null
    @SerializedName("sourcetimestamp")
    @Expose
    var sourcetimestamp: String? = null
    @SerializedName("monitored")
    @Expose
    var monitored: String? = null
}