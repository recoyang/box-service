package com.bolomessager.log.util

import org.slf4j.Logger

fun Logger.jsonInfo(message: String, jsonData: Any) {
    info(message, "jsonData", jsonData)
}

fun Logger.jsonError(message: String, jsonData: Any) {
    error(message, "jsonData", jsonData)
}