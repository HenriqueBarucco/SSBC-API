package com.henriquebarucco.ssbc.sensor.get

import com.henriquebarucco.ssbc.UseCase
import com.henriquebarucco.ssbc.sensor.get.dto.GetSensorByIdOutput

abstract class GetSensorByIdUseCase : UseCase<String, GetSensorByIdOutput>()
