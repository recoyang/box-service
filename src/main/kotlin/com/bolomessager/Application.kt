package com.bolomessager

import com.bolomessager.log.util.jsonError
import com.bolomessager.log.util.jsonInfo
import io.micronaut.context.ApplicationContext
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.runtime.Micronaut.*
import org.slf4j.LoggerFactory

lateinit var applicationContext: ApplicationContext
fun main(args: Array<String>) {
	applicationContext = run(*args)
}

@Controller("/log")
class LogController {
	private val logger = LoggerFactory.getLogger(LogController::class.java);
	@Post("/jsonInfo")
	fun jsonInfoLog(@Body logInfo: JsonLogInfo): String {
		logger.jsonInfo(logInfo.message, logInfo.jsonData)
		return "JsonInfo Log Generated"
	}

	@Post("/info")
	fun infoLog(@Body logInfo: LogInfo): String {
		logger.info(logInfo.message)
		return "Info Log Generated"
	}

	@Post("/jsonError")
	fun jsonErrorLog(@Body logInfo: JsonLogInfo): String {
		logger.jsonError(logInfo.message, logInfo.jsonData)
		return "JsonError Log Generated"
	}

	@Post("/error")
	fun errorLog(@Body logInfo: LogInfo): String {
		logger.error(logInfo.message)
		return "Error Log Generated"
	}
}

data class LogInfo(
	val message: String
)
data class JsonLogInfo(
	val message: String,
	val jsonData: Any
)