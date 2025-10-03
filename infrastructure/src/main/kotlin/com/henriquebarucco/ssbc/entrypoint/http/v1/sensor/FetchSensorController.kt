package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.FetchSensorRequest
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.FetchSensorResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/sensors")
interface FetchSensorController {
    @GetMapping
    fun fetchSensors(
        @Validated fetchSensorRequest: FetchSensorRequest,
    ): ResponseEntity<FetchSensorResponse>
}
