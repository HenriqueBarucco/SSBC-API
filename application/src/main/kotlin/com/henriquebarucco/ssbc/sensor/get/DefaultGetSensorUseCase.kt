package com.henriquebarucco.ssbc.sensor.get

import com.henriquebarucco.ssbc.sensor.SensorGateway
import com.henriquebarucco.ssbc.sensor.dto.GetSensorDto
import com.henriquebarucco.ssbc.sensor.get.dto.GetSensorOutput
import com.henriquebarucco.ssbc.sensor.get.dto.GetSensorQuery

class DefaultGetSensorUseCase(
    private val sensorGateway: SensorGateway,
) : GetSensorUseCase() {
    override fun execute(input: GetSensorQuery): GetSensorOutput? {
        val (pageSize,pageNumber,name, phoneNumber) = input
        val getSensorDto = GetSensorDto(
            pageSize=pageSize,
            pageNumber=pageNumber,
            name = name,
            phoneNumber = phoneNumber,
        )
        val sensorPageDto = this.sensorGateway.getSensor(getSensorDto)
        return GetSensorOutput.fromSensorPageDto(sensorPageDto)
    }
}