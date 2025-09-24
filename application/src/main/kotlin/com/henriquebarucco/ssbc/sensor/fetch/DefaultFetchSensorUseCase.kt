package com.henriquebarucco.ssbc.sensor.fetch

import com.henriquebarucco.ssbc.sensor.Sensor
import com.henriquebarucco.ssbc.sensor.SensorGateway
import com.henriquebarucco.ssbc.sensor.dto.FetchSensorDto
import com.henriquebarucco.ssbc.sensor.get.dto.FetchSensorCommand
import com.henriquebarucco.ssbc.shared.PaginatedOutput

class DefaultFetchSensorUseCase(
    private val sensorGateway: SensorGateway,
) : FetchSensorUseCase() {
    override fun execute(input: FetchSensorCommand): PaginatedOutput<Sensor> {
        val (pageSize, pageNumber, name, phoneNumber) = input
        val fetchSensorDto =
            FetchSensorDto(
                pageSize = pageSize,
                pageNumber = pageNumber,
                name = name,
                phoneNumber = phoneNumber,
            )
        val sensorPageDto = this.sensorGateway.getSensor(fetchSensorDto)
        return PaginatedOutput(
            content = sensorPageDto.content,
            totalElements = sensorPageDto.totalElements,
            totalPages = sensorPageDto.totalPages,
        )
    }
}
