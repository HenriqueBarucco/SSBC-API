package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.request

import com.henriquebarucco.ssbc.sensor.update.dto.UpdateSensorCommand

data class UpdateSensorRequest(
    val name: String?,
    val phoneNumber: String?,
    val delayToNotify: Long?,
) {
    fun toCommand(id: String): UpdateSensorCommand =
        UpdateSensorCommand(
            id = id,
            name = this.name,
            phoneNumber = this.phoneNumber,
            delayToNotify = this.delayToNotify,
        )
}
