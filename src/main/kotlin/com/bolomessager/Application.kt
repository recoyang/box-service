package com.bolomessager

import ch.qos.logback.classic.spi.ILoggingEvent
import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.context.ApplicationContext
import io.micronaut.gcp.logging.StackdriverJsonLayout
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.runtime.Micronaut.*
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.slf4j.Logger
import org.slf4j.LoggerFactory

lateinit var applicationContext: ApplicationContext
fun main(args: Array<String>) {
	applicationContext = run(*args)
}

@Controller("/log")
class LogController {
	private val logger = LoggerFactory.getLogger(LogController::class.java);
	@Post("/info")
	fun infoLog(@Body logInfo: LogInfo): String {
		logger.jsonInfo(logInfo.message, logInfo.jsonData)
		return "Info Log Generated"
	}
	@Post("/error")
	fun errorLog(@Body logInfo: LogInfo): String {
		logger.jsonError(logInfo.message, logInfo.jsonData)
		return "Error Log Generated"
	}
}
data class LogInfo(
	val message: String,
	val jsonData: Any
)