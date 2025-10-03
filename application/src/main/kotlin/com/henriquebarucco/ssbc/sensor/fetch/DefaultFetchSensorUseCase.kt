package com.henriquebarucco.ssbc.sensor.fetch

import com.henriquebarucco.ssbc.sensor.Sensor
import com.henriquebarucco.ssbc.sensor.SensorGateway
import com.henriquebarucco.ssbc.sensor.dto.FetchSensorsDto
import com.henriquebarucco.ssbc.sensor.fetch.dto.FetchSensorsCommand
import com.henriquebarucco.ssbc.shared.PaginatedOutput

class DefaultFetchSensorUseCase(
    private val sensorGateway: SensorGateway,
) : FetchSensorUseCase() {
    override fun execute(input: FetchSensorsCommand): PaginatedOutput<Sensor> {
        val (pageSize, pageNumber, name, phoneNumber) = input
        val fetchSensorsDto =
            FetchSensorsDto(
                pageSize = pageSize,
                pageNumber = pageNumber,
                name = name,
                phoneNumber = phoneNumber,
            )
        val sensorPageDto = this.sensorGateway.fetch(fetchSensorsDto)
        return PaginatedOutput(
            content = sensorPageDto.content,
            totalElements = sensorPageDto.totalElements,
            totalPages = sensorPageDto.totalPages,
        )
    }
}
