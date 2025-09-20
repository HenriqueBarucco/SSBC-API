package com.henriquebarucco.ssbc.sensor.get

import com.henriquebarucco.ssbc.UseCase
import com.henriquebarucco.ssbc.sensor.PaginatedOutput
import com.henriquebarucco.ssbc.sensor.Sensor
import com.henriquebarucco.ssbc.sensor.get.dto.GetSensorCommand

abstract class GetSensorUseCase : UseCase<GetSensorCommand, PaginatedOutput<Sensor>>()