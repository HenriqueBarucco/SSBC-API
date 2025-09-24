package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.impl

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.GetSensorByIdController
import com.henriquebarucco.ssbc.sensor.get.GetSensorByIdUseCase
import com.henriquebarucco.ssbc.sensor.get.dto.GetSensorByIdOutput
import org.springframework.web.bind.annotation.RestController

@RestController
class GetSensorByIdControllerImpl(
    private val getSensorBydIdUseCase: GetSensorByIdUseCase,
) : GetSensorByIdController {
    override fun getSensorById(id: String): GetSensorByIdOutput = getSensorBydIdUseCase.execute(id)
}
