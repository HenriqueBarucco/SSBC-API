package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor

import com.henriquebarucco.ssbc.sensor.get.dto.GetSensorByIdOutput
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

interface GetSensorByIdController {

    @GetMapping("/sensors/{id}")
    fun getSensorById(@PathVariable id: String) : GetSensorByIdOutput
}