package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.request.FetchSensorRequest
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.response.FetchSensorsResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/sensors")
interface FetchSensorsController {
    @GetMapping
    fun fetchSensors(
        @Validated fetchSensorRequest: FetchSensorRequest,
    ): ResponseEntity<FetchSensorsResponse>
}
