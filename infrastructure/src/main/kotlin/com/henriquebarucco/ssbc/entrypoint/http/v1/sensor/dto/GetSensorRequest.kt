package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto

import com.henriquebarucco.ssbc.sensor.get.dto.GetSensorCommand
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Size

data class GetSensorRequest(
    @field:Size(min = 0, max = 255)
    val name: String?,
    @field:Size(min = 0, max = 13)
    val phoneNumber: String?,
    val page: Int = 0,
    @field:Max(50)
    @field:Min(1)
    val size: Int = 20
) {
    fun toCommand(): GetSensorCommand =
        GetSensorCommand(
            name = name,
            phoneNumber = phoneNumber,
            pageSize = size,
            pageNumber = page,
        )
}