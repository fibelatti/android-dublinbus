package com.fibelatti.dublinbus.helpers

class Utils {
    companion object
}

fun <T1, T2> Utils.Companion.ifNotNull(value1: T1?, value2: T2?, bothNotNull: (T1, T2) -> (Unit)) {
    if (value1 != null && value2 != null) {
        bothNotNull(value1, value2)
    }
}