package com.bolomessager

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	run(*args)
}

@Controller("/test")
class TestController {
	@Get
	fun getMessage(): String {
		return "This is box service"
	}
}
