package com.bolomessager

import ch.qos.logback.classic.spi.ILoggingEvent
import io.micronaut.gcp.logging.StackdriverJsonLayout
import org.slf4j.Logger

fun Logger.jsonInfo(message: String, jsonData: Any) {
    info(message, "jsonData", jsonData)
}

fun Logger.jsonError(message: String, jsonData: Any) {
    error(message, "jsonData", jsonData)
}

class GCPLayout: StackdriverJsonLayout() {
    override fun addCustomDataToJsonMap(map: MutableMap<String, Any>, event: ILoggingEvent) {
        if (event.argumentArray.size == 2 && event.argumentArray.first().equals("jsonData")) {
            val json = event.argumentArray[1]
            map["customData"] = json
        }
    }
}