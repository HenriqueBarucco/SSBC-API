package com.henriquebarucco.ssbc.sensor.get

import com.henriquebarucco.ssbc.sensor.PaginatedOutput
import com.henriquebarucco.ssbc.sensor.Sensor
import com.henriquebarucco.ssbc.sensor.SensorGateway
import com.henriquebarucco.ssbc.sensor.dto.GetSensorDto
import com.henriquebarucco.ssbc.sensor.get.dto.GetSensorCommand

class DefaultGetSensorUseCase(
    private val sensorGateway: SensorGateway,
) : GetSensorUseCase() {
    override fun execute(input: GetSensorCommand): PaginatedOutput<Sensor> {
        val (pageSize,pageNumber,name, phoneNumber) = input
        val getSensorDto = GetSensorDto(
            pageSize=pageSize,
            pageNumber=pageNumber,
            name = name,
            phoneNumber = phoneNumber,
        )
        val sensorPageDto = this.sensorGateway.getSensor(getSensorDto)
        return PaginatedOutput(
            content = sensorPageDto.content,
            totalElements = sensorPageDto.totalElements,
            totalPages= sensorPageDto.totalPages,
        )
    }
}