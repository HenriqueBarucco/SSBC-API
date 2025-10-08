package com.henriquebarucco.ssbc.sensor.detected.dto

data class SensorDetectedCommand(
    val sensorId: String,
    val base64: String?,
)
