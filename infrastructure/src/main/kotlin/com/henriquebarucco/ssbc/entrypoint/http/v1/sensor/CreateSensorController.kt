package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.request.CreateSensorRequest
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.response.CreateSensorResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/sensors")
interface CreateSensorController {
    @PostMapping
    fun createSensor(
        @RequestBody @Validated request: CreateSensorRequest,
    ): ResponseEntity<CreateSensorResponse>
}
