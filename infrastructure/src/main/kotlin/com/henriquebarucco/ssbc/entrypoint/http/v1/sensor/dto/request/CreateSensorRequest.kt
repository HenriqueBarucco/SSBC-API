package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.request

import com.henriquebarucco.ssbc.sensor.create.dto.CreateSensorCommand
import jakarta.validation.constraints.NotBlank

data class CreateSensorRequest(
    @field:NotBlank
    val name: String,
    @field:NotBlank
    val phoneNumber: String,
) {
    fun toCommand() =
        CreateSensorCommand(
            name = name,
            phoneNumber = phoneNumber,
        )
}
