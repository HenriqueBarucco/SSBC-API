package com.henriquebarucco.ssbc.sensor.update

import com.henriquebarucco.ssbc.UseCase
import com.henriquebarucco.ssbc.sensor.update.dto.UpdateSensorCommand
import com.henriquebarucco.ssbc.sensor.update.dto.UpdateSensorOutput

abstract class UpdateSensorUseCase : UseCase<UpdateSensorCommand, UpdateSensorOutput>()
