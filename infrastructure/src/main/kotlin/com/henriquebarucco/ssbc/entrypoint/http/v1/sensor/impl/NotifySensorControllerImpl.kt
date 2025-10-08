package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.impl

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.NotifySensorController
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.request.NotifySensorRequest
import com.henriquebarucco.ssbc.sensor.detected.SensorDetectedUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class NotifySensorControllerImpl(
    private val sensorDetectedUseCase: SensorDetectedUseCase,
) : NotifySensorController {
    override fun notifySensor(
        request: NotifySensorRequest,
        id: String,
    ): ResponseEntity<Void> {
        val command = request.toCommand(id)
        this.sensorDetectedUseCase.execute(command)

        return ResponseEntity.noContent().build()
    }
}
