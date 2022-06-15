package com.bolomessager.log.layout

import ch.qos.logback.classic.spi.ILoggingEvent
import io.micronaut.gcp.logging.StackdriverJsonLayout


class GCPLayout: StackdriverJsonLayout() {
    override fun addCustomDataToJsonMap(map: MutableMap<String, Any>, event: ILoggingEvent) {
        if (event.argumentArray != null && event.argumentArray.size == 2 && event.argumentArray.first().equals("jsonData")) {
            val json = event.argumentArray[1]
            map["customData"] = json
        }
    }
}
