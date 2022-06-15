package com.bolomessager.log.layout

import ch.qos.logback.classic.PatternLayout
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.pattern.PatternLayoutEncoderBase
import com.fasterxml.jackson.databind.ObjectMapper

class JsonPatternLayout: PatternLayout() {
    private val mapper = ObjectMapper()
    override fun doLayout(event: ILoggingEvent): String {
        var string = super.doLayout(event)
        if (event.argumentArray != null && event.argumentArray.size == 2 && event.argumentArray.first().equals("jsonData")) {
            val json = event.argumentArray[1]
            val prettyJsonString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(json)
            string = "${string}jsonData: $prettyJsonString"
        }
        return string
    }
}
class JsonPatternLayoutEncoder: PatternLayoutEncoderBase<ILoggingEvent>() {
    override fun start() {
        val jsonPatternLayout = JsonPatternLayout()
        jsonPatternLayout.context = context
        jsonPatternLayout.pattern = pattern
        jsonPatternLayout.isOutputPatternAsHeader = outputPatternAsHeader
        jsonPatternLayout.start()
        layout = jsonPatternLayout
        super.start()
    }
}