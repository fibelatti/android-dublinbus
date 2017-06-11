package com.fibelatti.dublinbus.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StopInformation {

    @SerializedName("errorcode")
    @Expose
    var errorcode: String? = null
    @SerializedName("errormessage")
    @Expose
    var errormessage: String? = null
    @SerializedName("numberofresults")
    @Expose
    var numberofresults: Int? = null
    @SerializedName("stopid")
    @Expose
    var stopid: String? = null
    @SerializedName("timestamp")
    @Expose
    var timestamp: String? = null
    @SerializedName("results")
    @Expose
    var results: List<StopInformationResult>? = null

}