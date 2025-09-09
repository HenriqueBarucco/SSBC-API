package com.henriquebarucco.ssbc.sensor.create

import com.henriquebarucco.ssbc.UseCase
import com.henriquebarucco.ssbc.sensor.create.dto.CreateSensorCommand
import com.henriquebarucco.ssbc.sensor.create.dto.CreateSensorOutput

abstract class CreateSensorUseCase : UseCase<CreateSensorCommand, CreateSensorOutput>()
