package com.henriquebarucco.ssbc.sensor.get.dto

import com.henriquebarucco.ssbc.sensor.Sensor
import com.henriquebarucco.ssbc.sensor.dto.SensorPageDto


data class GetSensorOutput(
    val content: List<Sensor>?,
    val totalElements: Long,
    val totalPages: Int,
) {

    companion object {
        fun fromSensorPageDto(sensorPageDto: SensorPageDto?): GetSensorOutput? {
            if (sensorPageDto == null) return null

            return GetSensorOutput(
                content = sensorPageDto.content,
                totalElements = sensorPageDto.totalElements,
                totalPages = sensorPageDto.totalPages,
            )
        }
    }

}