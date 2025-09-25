package com.henriquebarucco.ssbc.sensor.fetch

import com.henriquebarucco.ssbc.UseCase
import com.henriquebarucco.ssbc.sensor.Sensor
import com.henriquebarucco.ssbc.sensor.fetch.dto.FetchSensorsCommand
import com.henriquebarucco.ssbc.shared.PaginatedOutput

abstract class FetchSensorUseCase : UseCase<FetchSensorsCommand, PaginatedOutput<Sensor>>()
