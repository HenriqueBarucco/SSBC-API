package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.GetSensorRequest
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.GetSensorResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/sensors")
interface GetSensorController {

    @GetMapping
    fun getSensors(@Validated getSensorRequest: GetSensorRequest): ResponseEntity<GetSensorResponse>

}