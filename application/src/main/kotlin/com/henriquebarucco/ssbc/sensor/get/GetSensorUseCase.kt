package com.henriquebarucco.ssbc.sensor.get

import com.henriquebarucco.ssbc.UseCase
import com.henriquebarucco.ssbc.sensor.get.dto.GetSensorOutput
import com.henriquebarucco.ssbc.sensor.get.dto.GetSensorQuery

abstract class GetSensorUseCase : UseCase<GetSensorQuery, GetSensorOutput?>()